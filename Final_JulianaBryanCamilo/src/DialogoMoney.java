import processing.core.PApplet;
import processing.core.PImage;

public class DialogoMoney extends Dialogo {

	public DialogoMoney(PApplet app, int x, int y, PImage[] p) {
		super(app, x, y, p);
		burbuja = 3;
		
	}

	@Override
	public void pintar() {
		app.imageMode(app.CENTER);
		switch (burbuja) {
		case 0:
			app.image(p[c], x, y);
			break;
		case 1:
			app.image(p[c], x + 250, y-100);
			break;
		case 2:
			app.image(p[c], x-20, y-90);
			break;
		case 3:
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
			if (x>468 && x < 577 && y > 264&& y <307) {
				c = 1;
			}
			else if (x > 437&& x < 588 && y > 327 && y < 360) {
				c = 2;
			}
			else if (x > 541 && x < 699 && y > 375 && y < 413) {
				c = 3;
			}else{
				c = 0;
			}
			break;
		case 1:
			if (x > 685 && x <792 && y > 167 && y < 222) {
				c = 5;
			}
			else if (x > 591 && x < 706 && y > 284 && y < 384) {
				c = 6;
			}
			else if (x > 879 && x < 294 && y > 1041 && y < 335) {
				c = 7;
			}else{
				c = 4;
			}
			break;
		case 2:
			if (x > 551 && x <670 && y > 151 && y <204) {
				c = 5;
			}
			else if (x > 416 && x < 560 && y > 208 && y <208) {
				c = 6;
			}
			else if (x > 298 && x < 455 && y > 314 && y < 368) {
				c = 7;
			}else{
				c = 8;
			}
			break;}

	}

	@Override
	public void press(int x, int y) {
		if (x > 186 && x <291 && y > 439 && y < 657) {
			burbuja=0;
		}
		if (x > 494 && x <596 && y > 431 && y < 658) {
			burbuja=1;
		}
		if (x > 764 && x <871 && y > 445 && y < 655) {
			burbuja=2;
		}

	}

}
