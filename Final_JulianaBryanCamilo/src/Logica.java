import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	private PApplet app;
	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
	private PImage[] imgs = new PImage[0]; // se cambia cuanto sepamos cuantas
											// imgs son.
	private Ppal jugador;
	private int pantalla;
	private int variable;

	public Logica(PApplet app) {
		this.app = app;
		
	}

	public void juego() {
		switch (pantalla) {
		case 0: // incio
			// img
			// botones
			break;
		case 1: // instrucciones
			// img
			// botones
			break;
		case 2: // historias
			// sexualidad
			break;
		case 3:
			// Raza
			break;
		case 4:
			// estratos
			break;
		case 5: // Evaluaciones
			lvlOne();
			break;
		case 6:
			lvlTwo();
			break;
		}

	}

	public void leap() {
	
	}

	public void teclas(int tec) {

	}

	private void lvlOne() {

	}

	private void lvlTwo() {

	}
}
