package piano;

import processing.core.PApplet;
import processing.core.PImage;
import java.io.*;
import java.util.*;

public class Saving{

	private int x;
	private int y;
	private PImage saving;

	public Saving(int x, int y, PImage saving){
		this.x = x;
		this.y = y;
		this.saving = saving;
	}

	public void draw(PApplet app){
		app.image(saving, x, y);
    }
    
    public void saveAllBlocks(int[][] input){
        try{
            File recording = new File("src/main/records/recording.txt");
            PrintWriter pw = new PrintWriter(recording);
            for (int i=0; i<input.length; i++){
                pw.println(input[i][0]+" "+input[i][1]);
            }
            pw.close();
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

}