package starter.entity;

import java.awt.Rectangle;

public class Tile {
	final String top; //transparent background-black number
	final String bottom; //black background-white number
	
	Rectangle location;
	boolean flipped;
	
	public Tile(String up, String down, Rectangle rect, Boolean flip) {
		this.top = up;
		this.bottom = down;
		this.location = rect;
		this.flipped = flip;
	}
	
	public void flip() {
		flipped = !flipped;
	}
	
	public void setLocation (Rectangle r) {
		System.out.println("testing MT enters setLocation");
		this.location = r;
		System.out.println("testing MT setLocation"+this.location);
	}
	
	public String getVisibleDigit() {
		if (flipped) {return bottom;}
		return top;
	}

	public Rectangle getRectangle() {
		return location;
	}
	
	public boolean getFlipped() {
		return flipped;
	}

}
