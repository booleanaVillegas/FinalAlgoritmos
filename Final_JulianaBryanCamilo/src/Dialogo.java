import processing.core.PApplet;
import processing.core.PImage;

public class Dialogo extends Thread {
	int x, y;
	PApplet app;
	int i;

	public Dialogo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void pintar(PImage[] p, int i) {
		app.image(p[i], x, y);
	}
}
