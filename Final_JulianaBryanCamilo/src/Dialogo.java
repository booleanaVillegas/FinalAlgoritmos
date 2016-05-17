import processing.core.PApplet;
import processing.core.PImage;

public abstract class Dialogo extends Thread {
	protected int x, y, o;
	protected PApplet app;
	protected int i;
	protected PImage[] p;
	protected int burbuja, c;

	public Dialogo(PApplet app, int x, int y, PImage[] p) {
		this.app = app;
		this.x = x;
		this.y = y;
		this.p = p;
		o = 0;
	}

	public abstract void pintar();

	public abstract void animar();

	public abstract void press(int x, int y);

	public abstract void hover(int x, int y, PImage img);

	public void run() {
		while (true) {
			try {
				animar();
				sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
