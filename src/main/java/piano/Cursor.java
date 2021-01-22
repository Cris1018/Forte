package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class Cursor{

	private int y;
	private int x;
	private PImage cursor;
	private PImage redLine;
	private int speed;

	public Cursor(int x, PImage cursor){
		this.y = 60;
		this.x = x;
		this.cursor = cursor;
	}

	public void draw(PApplet app){
		app.image(cursor, x, y);
	}

	public void move(){
		if (this.x>525) this.x = 45;
		this.x += 5;
	}

	public int getX(){
		return this.x;
	}

	public void backToZero(){
		this.x = 45;
	}
}