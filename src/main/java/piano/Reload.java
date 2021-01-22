package piano;

import processing.core.PApplet;
import processing.core.PImage;
import java.io.*;
import java.util.*;

public class Reload{

	private int x;
	private int y;
    private PImage reload;

	public Reload(int x, int y, PImage reload){
		this.x = x;
		this.y = y;
		this.reload = reload;
	}

	public void draw(PApplet app){
		app.image(reload, x, y);
    }

    public List<Block> reloading(String name){
        List<Block> active = new ArrayList<Block>();
        try{
            File f = new File(name);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()){
                String[] nextline = s.nextLine().split(" ");
                Block b = new Block(Integer.parseInt(nextline[0]), Integer.parseInt(nextline[1]));
                b.setOn();
                active.add(b);
            }

        } catch (FileNotFoundException e){

        }
        return active;
    }

}