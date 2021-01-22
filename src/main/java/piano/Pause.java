package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class Pause{

	private int x;
	private int y;
	private PImage show;
	private boolean playing;

	public Pause(int x, int y, PImage pause){
		this.x = x;
		this.y = y;
		this.playing = false;
		this.show = pause;
	}

	public void draw(PApplet app){
		app.image(show, x, y);
	}

	public boolean state(){
		return this.playing;
	}

	public void start(PImage play){
		this.show = play;
		this.playing = true;
	}

	public void pause(PImage pause){
		this.show = pause;
		this.playing = false;
	}
}