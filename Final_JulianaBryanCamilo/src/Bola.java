import processing.core.PApplet;
import processing.core.PVector;

public class Bola extends Thread {
	private float radio;
	private PVector pos, vel, aceleracion;
	private PApplet app;

	private int colores;

	public Bola(PApplet app) {
		this.app = app;
		pos = new PVector(app.random(app.width), app.random(app.height));
		vel = new PVector(app.random(-7, 7), app.random(-7, 7));
		radio = app.random(10, 50);
		colores = (int) app.random(0, 5);
		start();
	}

	public void pintar() {
		app.noStroke();
		switch (colores) {
		case 0:
			app.fill(69, 255, 233, 200);
			break;
		case 1:
			app.fill(255, 80, 96, 200);
			break;
		case 2:
			app.fill(154, 127, 255, 200);
			break;
		case 3:
			app.fill(193, 255, 116, 200);
			break;
		case 4:
			app.fill(255, 0, 103, 200);
			break;
		}
		app.ellipse(pos.x, pos.y, radio, radio);
	}

	public void run() {
		while (true) {
			mover();
			vibracion();
			try {
				sleep(16);
			} catch (InterruptedException e) {
				System.out.println("ayayay");
			}
		}
	}

	public void mover() {
		limites();
		aceleracion = (new PVector(app.random(-10, 10), app.random(-10, 10)));
		pos.add(vel);

	}

	public void vibracion() {
		radio = radio + app.random(-1, 1);
		try {
			sleep(16);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void limites() {
		if (pos.x > app.width || pos.x < 0) {
			vel.x = vel.x * -1;
		}
		if (pos.y > app.width || pos.y < 0) {
			vel.y = vel.y * -1;
		}
	}
}
