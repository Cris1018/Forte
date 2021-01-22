package piano;

import processing.core.PApplet;
import processing.core.PImage;
import javax.sound.midi.*;

public class Keys{

	private int x;
	private int y;
	private int noteNum;
	private PImage keys;
	public MidiChannel channel;

	public Keys(int x, int y, PImage keys){
		this.x = x;
		this.y = y;
		this.keys = keys;
	}

	public MidiChannel setChannel(){
		try{		
			Synthesizer syn = MidiSystem.getSynthesizer();
			syn.open();
			this.channel = syn.getChannels()[0];
			return this.channel;
		} catch (Exception e){
			return null;
		} 
	}

	public Keys(int y, int noteNum){
		this.y = y;
		this.noteNum = noteNum;
	}

	public int getY(){
		return this.y;
	}

	public int getNoteNum(){
		return this.noteNum;
	}

	public void draw(PApplet app){
		app.image(keys, x, y);
	}
}