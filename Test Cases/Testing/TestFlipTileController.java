package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import org.junit.jupiter.api.Test;

import starter.boundary.Application;
import starter.boundary.Panel;
import starter.controller.FlipTileController;
import starter.entity.Model;
import starter.entity.Puzzle;
import starter.entity.Tile;
import starter.entity.TileSet;

class TestFlipTileController {

	@Test
	void testClickedNoTile() {
		Model m = new Model();
		TileSet ts = new TileSet();
		Puzzle p = new Puzzle(ts);
		Application app = new Application(m);
		Panel panel = app.getPanel();
		m.setPuzzle(p);
		
		Tile[][] correct = p.getTileSet().getInitialShape();
		
		int x = 0;
		int y = 0;
		
		MouseEvent me = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, 
						System.currentTimeMillis(), 0, x, y, 1, false);
		
		FlipTileController controller = new FlipTileController(app,m);
		controller.mousePressed(me);
		
		Tile[][] test = p.getShape();
		
		assertArrayEquals(correct[0], test[0]);
		assertArrayEquals(correct[1], test[1]);
		assertArrayEquals(correct[2], test[2]);
	}
		
	@Test
	void testClickedWrongTile() {
		Model m = new Model();
		TileSet ts = new TileSet();
		Puzzle p = new Puzzle(ts);
		Application app = new Application(m);
		Panel panel = app.getPanel();
		m.setPuzzle(p);

		Tile[][] correct = p.getTileSet().getInitialShape();
		
		int x = 250;
		int y = 250;
		
		MouseEvent me = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, 
						System.currentTimeMillis(), 0, x, y, 1, false);
		
		FlipTileController controller = new FlipTileController(app,m);
		controller.mousePressed(me);
		
		Tile[][] test = p.getShape();
		
		assertArrayEquals(correct[0], test[0]);
		assertArrayEquals(correct[1], test[1]);
		assertArrayEquals(correct[2], test[2]);
	}
	
	@Test
	void testJustWon() {
		Model m = new Model();
		TileSet ts = new TileSet();
		Puzzle p = new Puzzle(ts);
		Application app = new Application(m);
		Panel panel = app.getPanel();
		m.setPuzzle(p);
		m.setStatus(true,false);

		Tile[][] correct = p.getTileSet().getInitialShape();
		
		int x = 250;
		int y = 250;
		
		MouseEvent me = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, 
						System.currentTimeMillis(), 0, x, y, 1, false);
		
		FlipTileController controller = new FlipTileController(app,m);
		controller.mousePressed(me);
		
		Tile[][] test = p.getShape();
		
		assertArrayEquals(correct[0], test[0]);
		assertArrayEquals(correct[1], test[1]);
		assertArrayEquals(correct[2], test[2]);
	}
	
	@Test
	void testJustLost() {
		Model m = new Model();
		TileSet ts = new TileSet();
		Puzzle p = new Puzzle(ts);
		Application app = new Application(m);
		Panel panel = app.getPanel();
		m.setPuzzle(p);
		m.setStatus(false,true);

		Tile[][] correct = p.getTileSet().getInitialShape();
		
		int x = 250;
		int y = 250;
		
		MouseEvent me = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, 
						System.currentTimeMillis(), 0, x, y, 1, false);
		
		FlipTileController controller = new FlipTileController(app,m);
		controller.mousePressed(me);
		
		Tile[][] test = p.getShape();
		
		assertArrayEquals(correct[0], test[0]);
		assertArrayEquals(correct[1], test[1]);
		assertArrayEquals(correct[2], test[2]);
	}
	
	@Test
	void testClickedMovableTile() {
		Model m = new Model();
		Application app = new Application(m);
		Panel panel = app.getPanel();
		
		Rectangle r = new Rectangle(0,0,0,0);
		Tile m1 = new Tile("1","0",r,false);
		Tile m2 = new Tile("2","0",r,true);
		Tile m3 = new Tile("3","0",r,false);
		Tile m4 = new Tile("0","4",r,true);
		Tile m5 = new Tile("4","0",r,false);
		Tile m6 = new Tile("0","3",r,true);
		Tile m7 = new Tile("0","2",r,true);
		Tile m8 = new Tile("0","1",r,false);
		Tile[][] start = new Tile[][] {{m1, m2, null},
									   {m3, m4, m5},
									   {m6, m7, m8}};
		TileSet tiles = new TileSet();
		Puzzle puzzle = new Puzzle(tiles);	
		puzzle.setShape(start);	
		m.setPuzzle(puzzle);
		
		int x = (int) m2.getRectangle().getCenterX();
		int y = (int) m2.getRectangle().getCenterY();
		
		MouseEvent me = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, 
						System.currentTimeMillis(), 0, x, y, 1, false);
		
		FlipTileController controller = new FlipTileController(app,m);
		controller.mousePressed(me);	

		
		Tile[][] test = puzzle.getShape();
		Tile[][] correct = new Tile[][] {{m1, null, m2},
			   							 {m3, m4, m5},
			   							 {m6, m7, m8}};
			  							
		assertArrayEquals(correct[0], test[0]);
		assertArrayEquals(correct[1], test[1]);
		assertArrayEquals(correct[2], test[2]);
	}
	
	@Test
	void testClickedWinningTile() {
		Model m = new Model();
		Application app = new Application(m);
		Panel panel = app.getPanel();
		
		Rectangle r = new Rectangle(0,0,0,0);
		Tile w1 = new Tile("1","0",r,false);
		Tile w2 = new Tile("2","0",r,true);
		Tile w3 = new Tile("3","0",r,false);
		Tile w4 = new Tile("0","4",r,true);
		Tile w5 = new Tile("4","0",r,false);
		Tile w6 = new Tile("0","3",r,true);
		Tile w7 = new Tile("0","2",r,true);
		Tile w8 = new Tile("0","1",r,false);
		Tile w9 = new Tile("2","0",r,false);
		Tile[][] winShape = new Tile[][] {{w1, null, w3},
										  {w4, w2, w5},
										  {w6, w7, w8}};
		TileSet tiles = new TileSet();
		Puzzle puzzle = new Puzzle(tiles);	
		puzzle.setShape(winShape);	
		m.setPuzzle(puzzle);
		
		int x = (int) w2.getRectangle().getCenterX();
		int y = (int) w2.getRectangle().getCenterY();
		
		MouseEvent me = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, 
						System.currentTimeMillis(), 0, x, y, 1, false);
		
		FlipTileController controller = new FlipTileController(app,m);
		controller.mousePressed(me);	

		
		Tile[][] test = puzzle.getShape();
		Tile[][] correct = new Tile[][] {{w1, w9, w3},
			  							 {w4, null, w5},
			  							 {w6, w7, w8}};
			  							
		assertArrayEquals(correct[0], test[0]);
		assertArrayEquals(correct[1], test[1]);
		assertArrayEquals(correct[2], test[2]);
		
	}
	
	@Test
	void clickedLosingTile() {
		Model m = new Model();
		Application app = new Application(m);
		Panel panel = app.getPanel();

		Rectangle r = new Rectangle(0,0,0,0);
		Tile l1 = new Tile("1", "0", r, false);
		Tile l2 = new Tile("4", "0", r, false);
		Tile l3 = new Tile("1", "0", r, false);
		Tile l4 = new Tile("4", "0", r, true);
		Tile l5 = new Tile("1", "0", r, false);
		Tile l6 = new Tile("4", "0", r, false);
		Tile l7 = new Tile("1", "0", r, false);
		Tile l8 = new Tile("4", "0", r, false);
		
		final Tile[][] loseShape =  {{l1, null, l4},
									 {l2, l5, l7},
									 {l3, l6, l8}};
		
		TileSet tiles = new TileSet();
		Puzzle puzzle = new Puzzle(tiles);	
		puzzle.setShape(loseShape);	
		m.setPuzzle(puzzle);
		
		int x = (int) l4.getRectangle().getCenterX();
		int y = (int) l4.getRectangle().getCenterY();
		
		MouseEvent me = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, 
						System.currentTimeMillis(), 0, x, y, 1, false);
		
		FlipTileController controller = new FlipTileController(app,m);
		controller.mousePressed(me);	

		
		Tile[][] test = puzzle.getShape();
		Tile[][] correct = new Tile[][] {{l1, l4,null},
			 							 {l2, l5, l7},
			 							 {l3, l6, l8}};
		
		System.out.println("top      (l1) : "+test[0][0]);
		System.out.println("middle   (l4) : "+test[0][1]);
		System.out.println("bottom (null) : "+test[0][2]);
		
		assertArrayEquals(correct[0], test[0]);
		assertArrayEquals(correct[1], test[1]);
		assertArrayEquals(correct[2], test[2]);
	}

}
