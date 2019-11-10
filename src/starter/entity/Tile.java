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
		this.location = r;
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
	
	// functions below only exist because of testing
	public String getTop() {
		return this.top;
	}

	public String getBottom() {
		return this.bottom;
	}
	
	public boolean rectangleEquals(Rectangle r) {
		if(this.location.x!=r.x) {
			return false;
		}
		if(this.location.y!=r.y) {
			return false;
		}
		if(this.location.width!=r.width) {
			return false;
		}
		if(this.location.height!=r.height) {
			return false;
		}
		return true;
	}
	
	public boolean tileEquals(Tile t) {
		if(!this.top.equals(t.getTop())) {
			return false;
		}
		if(!this.bottom.equals(t.getBottom())) {
			return false;
		}
		if(this.flipped!=t.getFlipped()) {
			return false;
		}
		if(!this.rectangleEquals(t.getRectangle())) {
			return false;
		}
		return true;
	}

}
