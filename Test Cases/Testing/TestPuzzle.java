package Testing;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import starter.entity.Puzzle;
import starter.entity.Tile;
import starter.entity.TileSet;


class TestPuzzle {

	@Test
	void testWinFalse1() {
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		boolean win = p.checkWin();
		
		assertFalse(win);
	}
	
	@Test
	void testWinFalse2() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("1","0",r,true);
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
		
		assertFalse(win);
	}
	
	@Test
	void testWinFalse3() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("1","0",r,false);
		Tile w2 = new Tile("2","0",r,false);
		Tile w3 = new Tile("3","0",r,false);
		Tile w4 = new Tile("4","0",r,false);
		Tile w5 = new Tile("0","4",r,true);
		Tile w6 = new Tile("0","3",r,true);
		Tile w7 = new Tile("0","2",r,true);
		Tile w8 = new Tile("0","1",r,false);
		Tile[][] winShape = new Tile[][] {{w1, w2, w3},
										  {w4, null, w5},
										  {w6, w7, w8}};
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		p.setShape(winShape);
		boolean win = p.checkWin();

		assertFalse(win);
	}
	
	@Test
	void testWinFalse4() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("1","0",r,false);
		Tile w2 = new Tile("2","0",r,false);
		Tile w3 = new Tile("3","0",r,false);
		Tile w4 = new Tile("4","0",r,true);
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

		assertFalse(win);
	}
	
	@Test
	void testWinFalse5() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("1","0",r,false);
		Tile w2 = new Tile("2","0",r,false);
		Tile w3 = new Tile("3","0",r,false);
		Tile w4 = new Tile("4","0",r,false);
		Tile w5 = new Tile("0","4",r,false);
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

		assertFalse(win);
	}
	
	@Test
	void testWinFalse6() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("5","0",r,false);
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

		assertFalse(win);
	}
	
	@Test
	void testWinFalse7() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("1","0",r,false);
		Tile w2 = new Tile("2","0",r,false);
		Tile w3 = new Tile("3","0",r,false);
		Tile w4 = new Tile("4","0",r,false);
		Tile w5 = new Tile("0","4",r,true);
		Tile w6 = new Tile("0","3",r,true);
		Tile w7 = new Tile("0","2",r,true);
		Tile w8 = new Tile("0","5",r,true);
		Tile[][] winShape = new Tile[][] {{w1, w2, w3},
										  {w4, null, w5},
										  {w6, w7, w8}};
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		p.setShape(winShape);
		boolean win = p.checkWin();

		assertFalse(win);
	}
	
	@Test
	void testWinFalse8() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("1","0",r,false);
		Tile w2 = new Tile("2","0",r,false);
		Tile w3 = new Tile("3","0",r,false);
		Tile w4 = new Tile("5","0",r,false);
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

		assertFalse(win);
	}
	
	@Test
	void testWinFalse9() {
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("1","0",r,false);
		Tile w2 = new Tile("2","0",r,false);
		Tile w3 = new Tile("3","0",r,false);
		Tile w4 = new Tile("4","0",r,false);
		Tile w5 = new Tile("0","5",r,true);
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
	void testMovableTilesMiddle() {		
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		p.updatePuzzle(p.getShape()[0][1]);
		p.updatePuzzle(p.getShape()[1][1]);
		Tile c1 = p.getShape()[0][1];
		Tile c2 = p.getShape()[2][1];
		Tile c3 = p.getShape()[1][0];
		Tile c4 = p.getShape()[1][2];
		
		ArrayList<Tile> correct = new ArrayList<Tile>();
		correct.add(c1);
		correct.add(c2);
		correct.add(c3);
		correct.add(c4);
		
		ArrayList<Tile> test = p.movableTiles();

		assertEquals(correct.size(),test.size());
		assertEquals(correct.get(0),test.get(0)); 
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
	void testGetTileSet() {
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		
		TileSet test = p.getTileSet();
		
		TileSet correct = tiles;
		
		assertEquals(correct.getAllTiles(),test.getAllTiles());
		
	}
	
	@Test
	void testMoves() {
		TileSet t = new TileSet();
		Puzzle p = new Puzzle(t);
		
		p.addOneMove();
		
		int test = p.getMoves();
		int correct = 1;
		
		assertEquals(correct, test);
	}
}
