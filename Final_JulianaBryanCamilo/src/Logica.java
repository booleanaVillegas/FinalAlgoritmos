import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	private PApplet app;
	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
	private PImage[] imgs = new PImage[52]; 
	
	private PImage[] choices = new PImage[6];								
	private Ppal jugador;
	private int pantalla;
	private int variable;

	public Logica(PApplet app) {
		this.app = app;
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = app.loadImage("../data/img-" + (i + 1) + ".png");
		}
		for (int i = 0; i < 6; i++) {
			choices[i]=imgs[i+8];
		}
		
		jugador= new Ppal(app, 500, 300);
	}

	public void juego() {
		switch (pantalla) {
		case 0: // incio
			// img
			app.image(imgs[3], 0, 0);
			// botones
			break;
		case 1: // instrucciones
			// img
			app.image(imgs[6], 0, 0);
			// botones
			break;
		case 2: // historias
			app.image(imgs[4], 0, 0);
			//app.image(choices[5], 0, 0);
			jugador.pintar(choices);
			// closet
			break;
		case 3:
			//sexualidad
			app.image(imgs[1], 0, 0);
			break;
		case 4:
			// raza
			app.image(imgs[2], 0, 0);
			break;
		case 5:
			//estratps
			app.image(imgs[0], 0, 0);
		break;
		case 6: // preguntsd
			lvlOne();
			break;
		case 7:
			lvlTwo();
			break;
		}

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
			break;
		case 3: // historias
			if (tec == 37) {
				pantalla = 3;
			}
			break;
	
		case 4:
			if (tec == 37) {
				pantalla = 4;
			}
			break;
		case 5:
			if (tec == 37) {
				pantalla = 5;
			}

			break;
		case 6: // Evaluaciones

			break;
		case 7:

			break;
		}
	}

	private void lvlOne() {

	}

	private void lvlTwo() {

	}

	public void mouse(int x, int y) {
		switch (pantalla) {
		case 0: // incio
			if (x > 565 && y > 568 && x < 667 && y < 621) {
				pantalla = 2;
			}
			if (x > 485 && y > 650 && x < 757 && y < 708) {
				pantalla = 1;
			}
			break;
		case 1: // instrucciones

			break;
		case 2: // historias
			if (x > 493 && y > 704 && x <741 && y < 763) {
				pantalla = 3;
			}
			break;
		case 3:
			;
			break;
		case 4:
			// estratos

			break;
		case 5: // Evaluaciones

			break;
		case 6:

			break;
		case 7:

			break;
		}

	}
	

}
