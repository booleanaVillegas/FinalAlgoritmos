import processing.core.PApplet;
import processing.core.PImage;

public class Ppal {
	private PApplet app;
	private int x, y;
	private int personaje;


	public Ppal(PApplet app, int x, int y) {
		this.app = app;
		this.x = x;
		this.y = y;
		personaje=0;

	}

	public void pintar(PImage[] per) {
		
		app.image(per[personaje], x, y);
	}



	public void mover() {

	}

	public void vestir(int t) {
		if (t == 37) {// izq
			personaje--;
			if (personaje < 0) {
				personaje=5;
			}
		}
		if (t == 39) {// der
			personaje++;
			if (personaje > 5) {
				personaje=0;
			}
		}
	}
	public void setXandY(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
