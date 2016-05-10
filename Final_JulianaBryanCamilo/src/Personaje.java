import processing.core.PApplet;
import processing.core.PImage;

public class Personaje implements Runnable {
	private PApplet app;
	private int x;
	private int y;

	public Personaje (PApplet app,int x, int y){
		this.app=app;
		this.x=x;
		this.y=y;
	}
	public void pintar(PImage img){
	app.image(img, x, y);	
	}
	public void dialogo() {
		
	}
	public boolean interacutar(){
		return true;
		}
	
	public void run() {
	
		
	}
}
