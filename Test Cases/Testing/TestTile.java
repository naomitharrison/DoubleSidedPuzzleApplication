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

	@Test
	void testFunctionsCreatedForTestingForNoGoodReasonOtherThanPercentage() {
		Rectangle correctR = new Rectangle(0,0,0,0);
		Tile correct = new Tile("0","0",correctR,false);
		Tile correctTest = new Tile("0","0",correctR,false);
		
		assertTrue(correct.tileEquals(correctTest));

		Rectangle wrongR1 = new Rectangle(1,0,0,0);
		Rectangle wrongR2 = new Rectangle(0,1,0,0);
		Rectangle wrongR3 = new Rectangle(0,0,1,0);
		Rectangle wrongR4 = new Rectangle(0,0,0,1);
		Tile wrongRectangle1 = new Tile("0","0",wrongR1,false);
		Tile wrongRectangle2 = new Tile("0","0",wrongR2,false);
		Tile wrongRectangle3 = new Tile("0","0",wrongR3,false);
		Tile wrongRectangle4 = new Tile("0","0",wrongR4,false);

		assertFalse(correct.tileEquals(wrongRectangle1));
		assertFalse(correct.tileEquals(wrongRectangle2));
		assertFalse(correct.tileEquals(wrongRectangle3));
		assertFalse(correct.tileEquals(wrongRectangle4));
		
		Tile wrong1 = new Tile("1","0",correctR,false);
		Tile wrong2 = new Tile("0","1",correctR,false);
		Tile wrong3 = new Tile("0","0",correctR,true);

		assertFalse(correct.tileEquals(wrong1));
		assertFalse(correct.tileEquals(wrong2));
		assertFalse(correct.tileEquals(wrong3));
	}
}
