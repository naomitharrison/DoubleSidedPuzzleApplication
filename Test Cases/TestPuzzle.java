import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

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
		Tile w5 = new Tile("4","0",r,true);
		Tile w6 = new Tile("3","0",r,true);
		Tile w7 = new Tile("2","0",r,true);
		Tile w8 = new Tile("1","0",r,true);
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
	void testLose() {
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		boolean lose = p.checkLose();
		
		assertFalse(lose);
	}
}
