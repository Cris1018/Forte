package piano;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;

public class App extends PApplet {

	// private PImage sprite;
	private Keys keys;
	private Block block;
	private MiddleBanner middleBanner;
	private Banner banner;
	private PImage playButton;
	private PImage stopButton;
	private ButtonBack playbuttonBack;
	private ButtonBack stopbuttonBack;
	private ButtonBack savebuttonBack;
	private ButtonBack loadBack;
	private Pause p;
	private Stop st;
	private Saving save;
	private Reload load;
	private Cursor cursor;
	private Grids grid;
	private List<Block> allblocks = new ArrayList<Block>();
	private List<Keys> allKeys = new ArrayList<Keys>();

	// private HashMap<Keys, Integer> map = new HashMap<Keys, Integer>();
	
	public App() {
		// Initialise variables here
		Keys c = new Keys(315,60);
		allKeys.add(c);
		Keys c1 = new Keys(295,61);
		allKeys.add(c1);
		Keys d = new Keys(275,62);
		allKeys.add(d);	
		Keys d1 = new Keys(255,63);
		allKeys.add(d1);
		Keys e = new Keys(235,64);
		allKeys.add(e);
		Keys f = new Keys(215,65);
		allKeys.add(f);
		Keys f1 = new Keys(195,66);
		allKeys.add(f1);
		Keys g = new Keys(175,67);
		allKeys.add(g);
		Keys g1 = new Keys(155,68);
		allKeys.add(g1);
		Keys a = new Keys(135,69);
		allKeys.add(a);
		Keys a1 = new Keys(115,70);
		allKeys.add(a1);
		Keys b = new Keys(95,71);
		allKeys.add(b);
		Keys c2 = new Keys(75,72);
		allKeys.add(c2);    
	}

	public void settings() {
		// Don't touch
		size(540, 335);
	}

	public void setup() {
		
		frameRate(60);
		// Load images here
		this.banner = new Banner(0,0,this.loadImage("src/main/resources/banner.png"));
		this.middleBanner = new MiddleBanner(0,0,this.loadImage("src/main/resources/middleBanner.png"));
		this.keys = new Keys(0,75,this.loadImage("src/main/resources/keyboard.png"));      
		this.playbuttonBack = new ButtonBack(5,5,this.loadImage("src/main/resources/buttonBack.png"));
		this.stopbuttonBack = new ButtonBack(50,5,this.loadImage("src/main/resources/buttonBack.png"));
		this.savebuttonBack = new ButtonBack(140,5,this.loadImage("src/main/resources/buttonBack.png"));
		this.loadBack = new ButtonBack(95,5,this.loadImage("src/main/resources/buttonBack.png"));
		this.p = new Pause(6,6,this.loadImage("src/main/resources/play.png"));
		this.st = new Stop(51,6,this.loadImage("src/main/resources/stop.png"));
		this.save = new Saving(144,9,this.loadImage("src/main/resources/save.jpg"));
		this.load = new Reload(99,13,this.loadImage("src/main/resources/load.jpg"));
		this.grid = new Grids(60,75,this.loadImage("src/main/resources/grid.png"));
		this.cursor = new Cursor(45,this.loadImage("src/main/resources/pointer.png"));
	}
	
	public void draw() {
		// Draw your program here
		keys.draw(this);
		grid.draw(this);    
		middleBanner.draw(this);
		banner.draw(this);
		playbuttonBack.draw(this);
		stopbuttonBack.draw(this);
		savebuttonBack.draw(this);
		loadBack.draw(this);
		
		p.draw(this);
		st.draw(this);
		save.draw(this);
		load.draw(this);
		
		for (Block b: allblocks){
			b.draw(this);           
		}
		
		cursor.draw(this);		
		
		for (Keys k: allKeys){
			for (Block b: allblocks){
				if (b.getY() == k.getY()) b.activate(k);
			}
		}
		
		if (p.state() == true){
			cursor.move();
			for (Block b: allblocks){
				if (b.getX() == cursor.getX()){
					Keys current = b.getKey();
					current.setChannel().noteOn(current.getNoteNum(),100);
				}
			}
		}
	}


	public void mousePressed(){

		if (mouseX>=60 && mouseY>=75){
			int x_0 = mouseX-60;
			int y_0 = mouseY-75;
			int block_x = Math.floorDiv(x_0, 15);
			int block_y = Math.floorDiv(y_0, 20);

			block = new Block(60+15*block_x, 75+20*block_y, this.loadImage("src/main/resources/block.png"));
			block.setOn();
			allblocks.add(block);            
		}

		else if (mouseX>=5 && mouseX<=45 && mouseY>=5 && mouseY<=45){
			
			if (p.state()==false){
				p.start(this.loadImage("src/main/resources/pause.png"));
			}
			else{
				p.pause(this.loadImage("src/main/resources/play.png"));
			}
		} 

		else if (mouseX>=50 && mouseX<=90 && mouseY>=5 && mouseY<=45){
			if (p.state()== true){
				cursor.backToZero();
				allblocks.clear();
				p.pause(this.loadImage("src/main/resources/play.png"));
			}
		} 

		else if (mouseX>=95 && mouseX<=135 && mouseY>=5 && mouseY<=45){
			// cursor.backToZero();
			// allblocks.clear();			
			// allblocks = this.load.reloading("src/main/records/recording.txt");
		}
		
		else if (mouseX>=140 && mouseX<=180 && mouseY>=5 && mouseY<=45){
			int[][] currentBlocks;
			currentBlocks =  new int[this.allblocks.size()][2];
			for (int i=0; i<currentBlocks.length; i++){
				currentBlocks[i][0] = allblocks.get(i).getX();
				currentBlocks[i][1] = allblocks.get(i).getY();
			}
			save.saveAllBlocks(currentBlocks);
		}
	}


	public static void main(String[] args) {
		// Don't touch this
		PApplet.main("piano.App");
	}
}
