import processing.core.PApplet;

public class Ejecutable extends PApplet {
	private Logica log;

	public void setup() {
		size(1225-145, 793-93);
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

	public void mousePressed() {
		System.out.println(mouseX + "y" + mouseY);
		log.mouse(mouseX, mouseY);
	}

}
