import processing.core.PApplet;
import processing.core.PImage;

public class DialogoSex extends Dialogo {

	public DialogoSex(PApplet app, int x, int y, PImage[] p) {
		super(app, x, y, p);
		burbuja=2;
		
	}

	@Override
	public void pintar() {
		app.imageMode(app.CENTER);
		switch (burbuja) {
		case 0:
			app.image(p[c], x, y);
			break;
		case 1:
			app.image(p[c], x+50, y-30);
			break;
		case 2:
			break;
		}
		app.imageMode(app.CORNER);
	}

	@Override
	public void animar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hover(int x, int y) {
		switch (burbuja) {
		case 0:
			if (x > 314 && x < 497 && y > 234 && y < 273) {
				c = 1;
			}
			else if (x > 407 && x < 513 && y > 302 && y < 336) {
				c = 2;
			}else{
				c = 0;
			}
			break;
		case 1:
			if (x > 247 && x < 401 && y > 95 && y <150) {
				c = 4;
			}
			else if (x > 228 && x < 421 && y > 173 && y < 206) {
				c = 5;
			}
			else if (x >547 && x < 803 && y > 176 && y <216) {
				c = 6;
			}
			else if (x > 636 && x < 736 && y >238 && y < 266) {
				c = 7;
			}
			else if (x > 481 && x <730 && y > 332 && y < 356) {
				c = 8;
			}else{
				c = 3;
			}
			break;}
		
	}

	@Override
	public void press(int x, int y) {
		if (x > 586 && x < 773 && y > 406 && y < 689) {
			burbuja = 0;
		}
		if (x > 803 && x < 1048 && y > 395 && y < 681) {
			burbuja = 1;
		}	
	}

}