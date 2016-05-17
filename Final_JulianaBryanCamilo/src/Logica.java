import java.util.ArrayList;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioSample;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;
import processing.video.Capture;

public class Logica {
	private Minim minim;
	private AudioPlayer fondo;
	private AudioSample mal;
	private AudioSample boton;
	private AudioSample bien;
	private PApplet app;
	private Capture cam;
	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
	private PImage[] imgs = new PImage[21];
	private float manoX, manoY;
	private PImage[] choices = new PImage[6];
	private PImage camarita;
	private PImage[] dialogoSex = new PImage[9];
	private PImage[] dialogoRace = new PImage[19];
	private PImage[] dialogoMoney = new PImage[16];
	private Ppal jugador;
	private int pantalla;
	private int variable, one, two, three, malas;
	private ArrayList<Dialogo> dialogos = new ArrayList<Dialogo>();
	private ArrayList<Bola> bolitas = new ArrayList<Bola>();

	public Logica(PApplet app) {
		this.app = app;
		String[] cameras = Capture.list();
		//cam = new Capture(app, cameras[0]);
		//cam.start();
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = app.loadImage("../data/img-" + (i + 1) + ".png");
		}
		for (int i = 0; i < 6; i++) {
			choices[i] = imgs[i + 6];
		}
		for (int i = 0; i < dialogoSex.length; i++) {
			dialogoSex[i] = app.loadImage("../data/sexu(" + (i + 1) + ").png");
		}
		for (int i = 0; i < dialogoMoney.length; i++) {
			dialogoMoney[i] = app.loadImage("../data/money(" + (i + 1) + ").png");
		}
		for (int i = 0; i < dialogoRace.length; i++) {
			dialogoRace[i] = app.loadImage("../data/race(" + (i + 1) + ").png");
		}
		jugador = new Ppal(app, 450, 320);
		crearDialogos();
		for (int i = 0; i < 60; i++) {
			bolitas.add(new Bola(app));
		}
		minim = new Minim(app);
		  fondo = minim.loadFile("../data/fondo.mp3");
		  mal = minim.loadSample("../data/mal.mp3");
		  boton = minim.loadSample("../data/boton.mp3");
		  bien = minim.loadSample("../data/bien.mp3");
		  
		  fondo.loop();
	}

	public void crearDialogos() {
		dialogos.add(new DialogoSex(app, 480, 287, dialogoSex));
		dialogos.add(new DialogoRace(app, 222, 97, dialogoRace));
		dialogos.add(new DialogoMoney(app, 565, 361, dialogoMoney));
	}

	public void juego() {

		/*if (cam.available() == true) {
			cam.read();
		}
		camarita = cam.get();*/
		switch (pantalla) {
		case 0: // incio
			// img
			app.image(imgs[20], 0, 0);
			// botones
			break;
		case 1: // instrucciones
			// img
			app.image(imgs[3], 0, 0);
			// botones
			break;
		case 2: // historias
			app.image(imgs[2], 0, 0);
			// app.image(choices[5], 0, 0);
			jugador.pintar(choices);
			// closet
			break;
		case 3:
			// sexualidad
			app.image(imgs[14], 0, 0);
			dialogos.get(0).pintar();
			dialogos.get(0).hover(app.mouseX, app.mouseY);
			break;
		case 4:
			// raza
			app.image(imgs[1], 0, 0);
			dialogos.get(1).pintar();
			dialogos.get(1).hover(app.mouseX, app.mouseY);
			break;
		case 5:
			// estratos
			app.image(imgs[0], 0, 0);
			dialogos.get(2).pintar();
			dialogos.get(2).hover(app.mouseX, app.mouseY);
			break;
		case 6: // preguntsd
			preguntas();
			break;

		case 7:
			app.image(imgs[5], 0, 0);
			app.textSize(30);
			app.text(variable, 500, 400);
			break;
		case 10:
			//fiesta();
			
			for (Bola bola : bolitas) {
				bola.pintar();
			}

			break;
		}

	}

	private void fiesta() {
		camarita.loadPixels();
		PImage arcoiris = app.createImage(camarita.width, camarita.height, app.RGB);
		arcoiris.loadPixels();
		for (int i = 0; i < camarita.width; i++) {
			for (int j = 0; j < camarita.height; j++) {
				int matriz = i + (j * camarita.width);
				if (app.brightness(camarita.pixels[matriz]) < 50) {
					camarita.pixels[matriz] = app.color(0, 0, 0);
				}
				camarita.pixels[matriz] = app.color(i / 4, app.saturation(camarita.pixels[matriz]) + 10,
						app.brightness(camarita.pixels[matriz]));
				app.colorMode(app.HSB);
				int h = (int) app.hue(camarita.pixels[matriz]) + (int) (app.random(-50, 50));
				int s = (int) app.saturation(camarita.pixels[matriz]);
				int br = (int) app.brightness(camarita.pixels[matriz]);
				camarita.pixels[matriz] = app.color(h, s, br);
				app.colorMode(app.RGB);
				arcoiris.pixels[matriz] = app.color(i / 4, app.saturation(camarita.pixels[matriz]) + 10,
						app.brightness(camarita.pixels[matriz]));
			}
		}
		camarita.updatePixels();
		arcoiris.updatePixels();
		app.image(camarita, 0, 0);
		app.image(arcoiris, 0, 0);

	}

	public void leap() {

	}

	public void teclas(int tec) {
		switch (pantalla) {
		case 0: // incio

			break;
		case 1: // instrucciones

			break;
		case 2:
			jugador.vestir(tec);
			boton.trigger();
			break;
		case 3: // historias
			if (tec == 37) {
				pantalla = 2;
				boton.trigger();
			}
			if (tec == 39) {
				pantalla = 4;
				boton.trigger();
			}
			break;

		case 4:
			if (tec == 37) {
				pantalla = 3;
				boton.trigger();
			}
			if (tec == 39) {
				pantalla = 5;
				boton.trigger();
			}
			break;
		case 5:
			if (tec == 37) {
				pantalla = 4;
				boton.trigger();
			}
			if (tec == 39) {
				pantalla = 6;
				boton.trigger();
			}
			break;

		case 6: // Evaluaciones
			switch (one) {
			case 0:
				if (tec == 37) {
					// BIEEEEEN
					variable++;
					one = 1;
					bien.trigger();
					app.delay(200);
					
				}
				if (tec == 38) {
					malas++;
					one = 1;
					mal.trigger();
					app.delay(200);
				}
				if (tec == 39) {
					malas++;
					one = 1;
					mal.trigger();
					app.delay(200);
				}

				break;
			case 1:
				if (tec == 37) {
					// BIEEEEEN
					variable++;
					one = 2;
					bien.trigger();
					app.delay(200);
				}
				if (tec == 38) {
					malas++;
					one = 2;
					mal.trigger();
					app.delay(200);
				}
				if (tec == 39) {
					malas++;
					one = 2;
					mal.trigger();
					app.delay(200);
				}
				break;

			case 2:
				if (tec == 37) {
					// BIEEEEEN
					variable++;
					one = 3;
					bien.trigger();
					app.delay(200);
				}
				if (tec == 38) {
					malas++;
					one = 3;
					mal.trigger();
					app.delay(200);
				}
				if (tec == 39) {
					malas++;
					one = 3;
					mal.trigger();
					app.delay(200);
				}
				break;
			case 3:
				if (tec == 37) {
					malas++;
					one = 4;
					mal.trigger();
					app.delay(200);
				}
				if (tec == 38) {
					malas++;
					one = 4;
					mal.trigger();
					app.delay(200);
				}
				if (tec == 39) {
					variable++;
					one = 4;
					bien.trigger();
					app.delay(200);
				}

				break;
			case 4:

				if (tec == 37) {
					malas++;
					one = 5;
					mal.trigger();
					app.delay(200);
				}
				if (tec == 38) {
					variable++;
					one = 5;
					bien.trigger();
					app.delay(200);
				}
				if (tec == 39) {
					malas++;
					one = 5;
					mal.trigger();
					app.delay(200);
				}
				break;
			case 5:
				if (tec == 37) {
					// BIEEEEEN
					variable++;
					pantalla = 7;
					bien.trigger();
					app.delay(200);
				}
				if (tec == 38) {
					malas++;
					pantalla = 7;
					mal.trigger();
					app.delay(200);
				}
				if (tec == 39) {
					malas++;
					pantalla = 7;
					mal.trigger();
					app.delay(200);
				}

				break;

			}
		}
	}

	private void preguntas() {

		switch (one) {
		case 0:
			app.image(imgs[4], 0, 0);
			break;
		case 1:
			app.image(imgs[13], 0, 0);
			break;
		case 2:
			app.image(imgs[12], 0, 0);
			break;
		case 3:
			app.image(imgs[15], 0, 0);
			break;

		case 4:
			app.image(imgs[16], 0, 0);
			break;
		case 5:
			app.image(imgs[17], 0, 0);
			break;

		}
	}

	public void mouse(int x, int y) {
		switch (pantalla) {
		case 0: // incio
			if (x > 493 && y > 497 && x < 587 && y < 541) {
				pantalla = 2;
				boton.trigger();
			}
			if (x > 434 && y > 576 && x < 666 && y < 620) {
				pantalla = 1;
				boton.trigger();
			}
			break;
		case 1: // instrucciones

			break;
		case 2: // historias
			if (x > 430 && y > 622 && x < 665 && y < 673) {
				pantalla = 3;
				boton.trigger();
			}
			break;
		case 3:
			dialogos.get(0).press(x, y);
			boton.trigger();
			;
			break;
		case 4:
			dialogos.get(1).press(x, y);
			boton.trigger();
			break;
		case 5:
			dialogos.get(2).press(x, y);
			boton.trigger();
			break;
		case 6:

			break;

		
		case 7:
			pantalla = 10;
			boton.trigger();
			break;
		case 8:
			break;
		}

	}
}
