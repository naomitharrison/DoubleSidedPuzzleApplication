package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import starter.entity.Model;
import starter.entity.Puzzle;
import starter.entity.Tile;
import starter.entity.TileSet;

class TestModel {

	@Test
	void testSetStatus() {
		Model m = new Model();
		m.setStatus(true, true);
		
		boolean testWin = m.getWin();
		boolean testLose= m.getLose();
		
		assertTrue(testWin);
		assertTrue(testLose);
	}
	
	@Test
	void testResetStatus() {
		Model m = new Model();
		m.resetStatus();
		
		boolean testWin = m.getWin();
		boolean testLose= m.getLose();
		
		assertFalse(testWin);
		assertFalse(testLose);
	}
	
	@Test
	void testSetPuzzle() {
		Model m = new Model();
		TileSet ts = new TileSet();
		Puzzle p = new Puzzle(ts);
		m.setPuzzle(p);
		
		Puzzle test = m.getPuzzle();
		Tile[][] testShape = test.getShape();
		
		Tile[][] correctShape = p.getShape();
		
		assertArrayEquals(correctShape[0], testShape[0]);
		assertArrayEquals(correctShape[1], testShape[1]);
		assertArrayEquals(correctShape[2], testShape[2]);
	
	}
	
	@Test
	void testResetPuzzle() {
		Model m = new Model();
		m.resetPuzzle();
		
		Puzzle p = m.getPuzzle();
		Tile[][] testShape = p.getShape();
		
		Tile[][] correctShape = p.getTileSet().getInitialShape();
		
		assertArrayEquals(correctShape[0], testShape[0]);
		assertArrayEquals(correctShape[1], testShape[1]);
		assertArrayEquals(correctShape[2], testShape[2]);
	
	}

}
