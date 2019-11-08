package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import starter.entity.Model;
import starter.entity.Puzzle;
import starter.entity.Tile;
import starter.entity.TileSet;

class TestTileSet {
	
	// rectangles are used to put the tiles in the correct location/size in the display
	Rectangle LT = new Rectangle(100, 100, 100, 100);
	Rectangle LM = new Rectangle(100, 250, 100, 100);
	Rectangle LB = new Rectangle(100, 400, 100, 100);
	Rectangle MT = new Rectangle(250, 100, 100, 100);
	Rectangle MM = new Rectangle(250, 250, 100, 100);
	Rectangle MB = new Rectangle(250, 400, 100, 100);
	Rectangle RT = new Rectangle(400, 100, 100, 100);
	Rectangle RM = new Rectangle(400, 250, 100, 100);
	Rectangle RB = new Rectangle(400, 400, 100, 100);	
	
	// initial configuration: the last digit of my ID is 1
	Tile t1 = new Tile("1", "4", LT, false);
	Tile t2 = new Tile("4", "1", LM, true);
	Tile t3 = new Tile("3", "2", LB, true);
	Tile t4 = new Tile("4", "1", MT, false);
	Tile t5 = new Tile("3", "2", MM, false);
	Tile t6 = new Tile("2", "3", MB, false);
	Tile t7 = new Tile("4", "1", RM, false);
	Tile t8 = new Tile("3", "2", RB, false);
	
	Rectangle r = new Rectangle(0,0,0,0);
	Tile t0 = new Tile("0","0",r,false);	

	Model model = new Model();
	TileSet tiles = new TileSet();
	
	@Test
	void testAddRectangleLT() {
		Tile t = tiles.getFlipTile(t0, 0, 0);
		
		assertEquals(LT,t.getRectangle());
	}
	
	@Test
	void testAddRectangleLM() {
		Tile t = tiles.getFlipTile(t0, 1, 0);
		
		assertEquals(LM,t.getRectangle());
	}
	
	@Test
	void testAddRectangleLB() {
		Tile t = tiles.getFlipTile(t0, 2, 0);
		
		assertEquals(LB,t.getRectangle());
	}
	
	@Test
	void testAddRectangleMT() {
		Tile t = tiles.getFlipTile(t0, 0, 1);
		
		assertEquals(MT,t.getRectangle());
	}
	
	@Test
	void testAddRectangleMM() {
		Tile t = tiles.getFlipTile(t0, 1, 1);
		
		assertEquals(MM,t.getRectangle());
	}
	
	@Test
	void testAddRectangleMB() {
		Tile t = tiles.getFlipTile(t0, 2, 1);
		
		assertEquals(MB,t.getRectangle());
	}
	
	@Test
	void testAddRectangleRT() {
		Tile t = tiles.getFlipTile(t0, 0, 2);
		
		assertEquals(RT,t.getRectangle());
	}
	
	@Test
	void testAddRectangleRM() {
		Tile t = tiles.getFlipTile(t0, 1, 2);
		
		assertEquals(RM,t.getRectangle());
	}
	
	@Test
	void testAddRectangleRB() {
		Tile t = tiles.getFlipTile(t0, 2, 2);
		
		assertEquals(RB,t.getRectangle());
	}
	
	@Test
	void testGetAllTiles() {
		ArrayList<Tile> test = tiles.getAllTiles();

		ArrayList<Tile> correct = new ArrayList<Tile>();
		correct.add(t1);
		correct.add(t2);
		correct.add(t3);
		correct.add(t4);
		correct.add(t5);
		correct.add(t6);
		correct.add(t7);
		correct.add(t8);
		
		assertArrayEquals(correct.toArray(),test.toArray());
		
	}
	
}
