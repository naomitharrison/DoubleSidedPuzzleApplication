package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import starter.entity.Tile;

class TestTile {

	@Test
	void testFlip() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile t = new Tile("","",r,true);
		
		t.flip();
		
		boolean test = t.getFlipped();
		
		assertFalse(test);
	}

}
