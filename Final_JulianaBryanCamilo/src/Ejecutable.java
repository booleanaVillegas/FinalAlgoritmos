import processing.core.PApplet;

public class Ejecutable extends PApplet {
	private Logica log;

	public void setup() {
		size(1200, 700);
		log = new Logica(this);
	}

	public void draw() {
		background(0);
		log.juego();
		log.leap();
	}

	public void keyPressed() {
		log.teclas(keyCode);
	}

}
