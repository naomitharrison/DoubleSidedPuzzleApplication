import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import starter.entity.Puzzle;
import starter.entity.Tile;
import starter.entity.TileSet;


class TestPuzzle {

	@Test
	void testWinFalse() {
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		boolean win = p.checkWin();
		
		assertFalse(win);
	}
	
	@Test
	void testWinTrue() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("1","0",r,false);
		Tile w2 = new Tile("2","0",r,false);
		Tile w3 = new Tile("3","0",r,false);
		Tile w4 = new Tile("4","0",r,false);
		Tile w5 = new Tile("0","4",r,true);
		Tile w6 = new Tile("0","3",r,true);
		Tile w7 = new Tile("0","2",r,true);
		Tile w8 = new Tile("0","1",r,true);
		Tile[][] winShape = new Tile[][] {{w1, w2, w3},
										  {w4, null, w5},
										  {w6, w7, w8}};
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		p.setShape(winShape);
		boolean win = p.checkWin();
		
		assertTrue(win);
	}

	
	@Test
	void testLoseFalse() {
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		boolean lose = p.checkLose();
		
		assertFalse(lose);
	}
	
	@Test
	void testLoseTrue() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile l1 = new Tile("1", "0", r, false);
		Tile l2 = new Tile("4", "0", r, false);
		Tile l3 = new Tile("1", "0", r, false);
		Tile l4 = new Tile("4", "0", r, false);
		Tile l5 = new Tile("1", "0", r, false);
		Tile l6 = new Tile("4", "0", r, false);
		Tile l7 = new Tile("1", "0", r, false);
		Tile l8 = new Tile("4", "0", r, false);
		
		final Tile[][] loseShape =  {{l1, l4, null},
									 {l2, l5, l7},
									 {l3, l6, l8}};
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		p.setShape(loseShape);
		boolean lose = p.checkLose();
		
		assertTrue(lose);
	}
		
	@Test
	void testMovableTiles() {		
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		Tile c1 = p.getShape()[0][1];
		Tile c2 = p.getShape()[1][2];
		
		ArrayList<Tile> correct = new ArrayList<Tile>();
		correct.add(c1);
		correct.add(c2);
		
		ArrayList<Tile> test = p.movableTiles();

		assertEquals(correct.size(),test.size());
		//assertEquals(correct.get(0),test.get(0)); 
		//assert equals cant handle tile class so im gonna make my own equal(tile, tile) function at some point
	}

	
	@Test
	void testUpdatePuzzle() {
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		
		Tile t = p.getShape()[0][1];
		p.updatePuzzle(t);
		int[] test = p.getFindNullTile();
		int[] correct = new int[] {0,1};

		assertArrayEquals(correct,test);	
	}
	
	@Test
	void testResetPuzzle() {
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		
		Rectangle r = new Rectangle(0,0,0,0);
		Tile l1 = new Tile("1", "0", r, false);
		Tile l2 = new Tile("4", "0", r, false);
		Tile l3 = new Tile("1", "0", r, false);
		Tile l4 = new Tile("4", "0", r, false);
		Tile l5 = new Tile("1", "0", r, false);
		Tile l6 = new Tile("4", "0", r, false);
		Tile l7 = new Tile("1", "0", r, false);
		Tile l8 = new Tile("4", "0", r, false);
		
		final Tile[][] loseShape =  {{l1, l4, null},
									 {l2, l5, l7},
									 {l3, l6, l8}};
		
		p.setShape(loseShape);
		p.addOneMove();
		p.resetPuzzle();
		Tile[][] testShape = p.getShape();
		Tile[][] correctShape = tiles.getInitialShape();
		int testMoves = p.getMoves();
		int correctMoves=0;
		
		assertArrayEquals(correctShape[0],testShape[0]);
		assertArrayEquals(correctShape[1],testShape[1]);
		assertArrayEquals(correctShape[2],testShape[2]);

		assertEquals(correctMoves,testMoves); //this says it's not true even though it is and im mad
		
	}
}
