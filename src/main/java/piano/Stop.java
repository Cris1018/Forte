package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class Stop{

	private int x;
	private int y;
	private PImage stop;

	public Stop(int x, int y, PImage stop){
		this.x = x;
		this.y = y;
		this.stop = stop;
	}

	public void draw(PApplet app){
		app.image(stop, x, y);
	}
}