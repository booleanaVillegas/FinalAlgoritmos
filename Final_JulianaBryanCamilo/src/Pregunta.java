import processing.core.PImage;

public class Pregunta {
	int x, y;
	PImage[] img;
	String word;
	String[] respuestas;
	boolean pregUno;
	boolean qDos; // q de question
	boolean qTres;
	boolean qCuatro;

	public Pregunta(String word, int x, int y) {
		this.x = x;
		this.y = y;
		this.word = word;
	}

	public void responder() {

	}

	public void interactuar() {

	}
}
