import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	private PApplet app;
	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
	private PImage[] imgs = new PImage[58];

	private PImage[] choices = new PImage[6];
	private Ppal jugador;
	private int pantalla;
	private int variable, one, two, three, malas;

	public Logica(PApplet app) {
		this.app = app;
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = app.loadImage("../data/img-" + (i + 1) + ".png");
		}
		for (int i = 0; i < 6; i++) {
			choices[i] = imgs[i + 6];
		}

		jugador = new Ppal(app, 450, 320);
	}

	public void juego() {

		switch (pantalla) {
		case 0: // incio
			// img
			app.image(imgs[57], 0, 0);
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
			app.image(imgs[50], 0, 0);
			break;
		case 4:
			// raza
			app.image(imgs[1], 0, 0);
			break;
		case 5:
			// estratps
			app.image(imgs[0], 0, 0);
			break;
		case 6: // preguntsd
			lvlOne();
			break;
		case 7:
			lvlTwo();
			break;
		case 8:
			lvlThree();
			break;
		case 9:
app.image(imgs[5], 0, 0);
app.textSize(30);
app.text(variable,0,0);
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
				pantalla = 2;
				
			}
			if (tec == 39) {
				pantalla = 4;
			}
			break;

		case 4:
			if (tec == 37) {
				pantalla = 3;
			}
			if (tec == 39) {
				pantalla = 5;
			}
			break;
		case 5:
			if (tec == 37) {
				pantalla = 4;
			}
			if (tec == 39) {
				pantalla = 6;
			}
			break;
		case 6: // Evaluaciones
			if (one == 0) {
				if (tec == 37) {
					// BIEEEEEN
					variable++;
					one = 1;
					
				}
				if (tec == 38) {
					malas++;
					one = 1;
					
				}
				if (tec == 39) {
					malas++;
					one = 1;
					
				}
			}
			
		if (one == 1) {
				if (tec == 37) {
					// BIEEEEEN
					variable++;
					pantalla = 7;
					
				}
				if (tec == 38) {
					malas++;
					pantalla = 7;
				
				}
				if (tec == 39) {
					malas++;
					pantalla = 7;
					 
			}
			}
			
			break;
		case 7:
			if (two == 0) {
				if (tec == 37) {
					// BIEEEEEN
					variable++;
					two = 1;
					 
				}
				if (tec == 38) {
					malas++;
					two = 1;
					 
				}
				if (tec == 39) {
					malas++;
					two = 1;
					 
				}
			}
			if (two == 1) {
				if (tec == 37) {
					malas++;
					pantalla = 8;
					 
				}    
				if (tec == 38) {
					malas++;
					pantalla = 8;
					 
				}    
				if (tec == 39) {
					variable++;
					pantalla = 8;
					 
				}
			}
			break;
		case 8:
			if (three == 0) {
				if (tec == 37) {
					malas++;
					three =1;
					 
				}
				if (tec == 38) {
					variable++;
					three =1;
					 
				}
				if (tec == 39) {
					malas++;
					three =1;
					 
				}
			}
			if (three == 1) {
				if (tec == 37) {
					// BIEEEEEN
					variable++;
					pantalla = 9;
					 
				}
				if (tec == 38) {
					malas++;
					pantalla =9;
					 
				}
				if (tec == 39) {
					malas++;
					pantalla =9;
					 
				}
			}
			break;
		case 9:

			break;
		}
	}

	private void lvlOne() {

		switch (one) {
		case 0:
			app.image(imgs[4], 0, 0);
			break;
		case 1:
			app.image(imgs[13], 0, 0);
			break;

		}
	}

	private void lvlTwo() {
		switch (two) {
		case 0:
			app.image(imgs[12], 0, 0);
			break;
		case 1:
			app.image(imgs[52], 0, 0);
			break;

		}
	}

	private void lvlThree() {
		switch (three) {
		case 0:
			app.image(imgs[53], 0, 0);
			break;
		case 1:
			app.image(imgs[54], 0, 0);
			break;

		}
	}

	public void mouse(int x, int y) {
		switch (pantalla) {
		case 0: // incio
			if (x > 493 && y > 497 && x < 587 && y < 541) {
				pantalla = 2;
			}
			if (x > 434 && y > 576 && x < 666 && y < 620) {
				pantalla = 1;
			}
			break;
		case 1: // instrucciones

			break;
		case 2: // historias
			if (x > 430 && y > 622 && x < 665 && y < 673) {
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
		case 8:

			break;
		
	case 9:

		break;
	

	}

}
}
