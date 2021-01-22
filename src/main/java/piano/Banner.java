package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class Banner{

	private int x;
	private int y;
	private PImage banner;

	public Banner(int x, int y, PImage banner){
		this.x = x;
		this.y = y;
		this.banner = banner;
	}

	public void draw(PApplet app){
		app.image(banner, x, y);
	}

}