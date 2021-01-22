package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class Grids{

	private int x;
	private int y;
	private PImage grids;

	public Grids(int x, int y, PImage grids){
		this.x = x;
		this.y = y;
		this.grids = grids;
	}

	public void draw(PApplet app){
		app.image(grids, x, y);
	}

}