package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class Block{
	
	private boolean isOn;
	private int x;
	private int y;
	private PImage block;
	private Keys key;

	public Block(int x, int y, PImage block){
		this.x = x;
		this.y = y;
		this.block = block;
	}

	public Block(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void draw(PApplet app){
		if (isOn == true){
			app.image(block, x, y);
		}
	}

	public void setOn(){
		this.isOn = true;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public void activate(Keys key){
		this.key = key;
	}

	public Keys getKey(){
		return this.key;
	}
}