package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class ButtonBack{

	private int x;
	private int y;
	private PImage buttonback;

	public ButtonBack(int x, int y, PImage buttonback){
		this.x = x;
		this.y = y;
		this.buttonback = buttonback;
	}

	public void draw(PApplet app){
		app.image(buttonback, x, y);
	}
}