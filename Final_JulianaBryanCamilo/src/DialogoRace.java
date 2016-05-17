import processing.core.PApplet;
import processing.core.PImage;

public class DialogoRace extends Dialogo {

	public DialogoRace(PApplet app, int x, int y, PImage[] p) {
		super(app, x, y, p);
		burbuja = 5;
	}

	@Override
	public void pintar() {
		app.imageMode(app.CENTER);
		switch (burbuja) {
		case 0:
			animar();
			app.tint(255, o);
			app.image(p[c], x, y);
			app.noTint();

			break;
		case 1:
			animar();
			app.tint(255, o);
			app.image(p[c], x + 200, y);
			app.noTint();

			break;
		case 2:
			animar();
			app.tint(255, o);
			app.image(p[c], x + 380, y);
			app.noTint();

			break;
		case 3:
			animar();
			app.tint(255, o);
			app.image(p[c], x + 500, y);
			app.noTint();

			break;
		case 4:
			animar();
			app.tint(255, o);
			app.image(p[c], x + 580, y);
			app.noTint();

			break;
		case 5:
			break;
		}
		app.imageMode(app.CORNER);
	}

	@Override
	public void animar() {
		o += 5;
	}

	@Override
	public void hover(int x, int y, PImage img) {
		switch (burbuja) {
		case 0:
			if (x > 18 && x < 275 && y > 51 && y < 91) {
				c = 1;
				op=15;
			} else if (x > 198 && x < 311 && y > 110 && y < 136) {
				c = 2;
				op=15;
			} else if (x > 76 && x < 262 && y > 156 && y < 194) {
				c = 3;
				op=15;
			} else {
				c = 0;
				op=255;
			}
			break;
		case 1:
			if (x > 223 && x < 387 && y > 84 && y < 131) {
				c = 5;
				op=15;
			} else if (x > 271 && x < 346 && y > 131 && y < 174) {
				c = 6;
				op=15;
			} else if (x > 446 && x < 564 && y > 134 && y < 186) {
				c = 7;
				op=15;
			} else {
				c = 4;
				op=255;

			}
			break;
		case 2:
			if (x > 403 && x < 534 && y > 76 && y < 113) {
				c = 9;
				op=15;
			} else if (x > 404 && x < 504 && y > 131 && y < 173) {
				c = 10;
				op=15;
			} else if (x > 646 && x < 784 && y > 126 && y < 166) {
				c = 11;
				op=15;
			} else {
				c = 8;
				op=255;
			}
			break;
		case 3:
			if (x > 508 && x < 627 && y > 76 && y < 119) {
				c = 13;
				op=15;
			} else if (x > 514 && x < 656 && y > 142 && y < 179) {
				c = 14;
				op=15;
			} else if (x > 756 && x < 921 && y > 144 && y < 182) {
				c = 15;
				op=15;
			} else {
				c = 12;
				op=255;
			}
			break;
		case 4:
			if (x > 696 && x < 804 && y > 75 && y < 119) {
				c = 17;
			} else if (x > 602 && x < 711 && y > 131 && y < 180) {
				c = 18;
			} else {
				c = 16;
				op=255;
			}
			break;

		}

	}

	@Override
	public void press(int x, int y) {

		if (x > 40 && x < 285 && y > 252 && y < 640) {
			burbuja = 0;
		}
		if (x > 260 && x < 440 && y > 209 && y < 635) {
			burbuja = 1;
		}
		if (x > 472 && x < 600 && y > 197 && y < 608) {
			burbuja = 2;
		}
		if (x > 649 && x < 727 && y > 278 && y < 648) {
			burbuja = 3;
		}
		if (x > 751 && x < 916 && y > 233 && y < 545) {
			burbuja = 4;
		}

	}

}
