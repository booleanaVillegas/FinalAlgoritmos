import processing.core.PApplet;
import processing.core.PImage;

public class Ppal {
private PApplet app;
private int x,y;
private int personaje;
private PImage[] img;

	public Ppal(PApplet app, int x,int y ){
		this.app=app;
		this.x=x;
		this.y=y;
		
	}
	
	public void pintar(PImage[] per){
		app.image(per[personaje], x, y);
	}
	public void mover(){
		
	}
	public void vestir(){
		
	}
}
