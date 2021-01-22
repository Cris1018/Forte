package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class MiddleBanner{

	private int x;
	private int y;
	private PImage middlebanner;

	public MiddleBanner(int x, int y, PImage middlebanner){
		this.x = x;
		this.y = y;
		this.middlebanner = middlebanner;
	}

	public void draw(PApplet app){
		app.image(middlebanner, x, y);
	}
}