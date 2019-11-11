package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import org.junit.jupiter.api.Test;

import Testing.GUITestCase;
import starter.boundary.Application;
import starter.boundary.Panel;
import starter.controller.FlipTileController;
import starter.entity.Model;
import starter.entity.Puzzle;
import starter.entity.Tile;
import starter.entity.TileSet;

class TestFlipTileController extends GUITestCase {

	@Test
	void testClickedNoTile() {
		Model m = new Model();
		TileSet ts = new TileSet();
		Puzzle p = new Puzzle(ts);
		Application app = new Application(m);
		Panel panel = app.getPanel();
		m.setPuzzle(p);

		Tile[][] correct = p.getTileSet().getInitialShape();

		FlipTileController controller = new FlipTileController(app, m);
		controller.mousePressed(new Point(0, 0));

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

		FlipTileController controller = new FlipTileController(app, m);
		controller.mousePressed(new Point(250, 250));

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
		m.setStatus(true, false);

		Tile[][] correct = p.getTileSet().getInitialShape();

		FlipTileController controller = new FlipTileController(app, m);
		controller.mousePressed(new Point(250, 250));

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
		m.setStatus(false, true);

		Tile[][] correct = p.getTileSet().getInitialShape();

		FlipTileController controller = new FlipTileController(app, m);
		controller.mousePressed(new Point(250, 250));

		Tile[][] test = p.getShape();

		assertArrayEquals(correct[0], test[0]);
		assertArrayEquals(correct[1], test[1]);
		assertArrayEquals(correct[2], test[2]);
	}

	@Test
	void testWinningShape() {
		Model m = new Model();
		Application app = new Application(m);

		Rectangle r = new Rectangle(0, 0, 0, 0);
		Tile w1 = new Tile("1", "0", r, false);
		Tile w2 = new Tile("2", "0", r, false);
		Tile w3 = new Tile("3", "0", r, false);
		Tile w4 = new Tile("0", "4", r, true);
		Tile w5 = new Tile("4", "0", r, false);
		Tile w6 = new Tile("0", "3", r, true);
		Tile w7 = new Tile("0", "2", r, true);
		Tile w8 = new Tile("0", "1", r, true);
		Tile[][] winShape = new Tile[][] { { w1, w2, w3 }, { w4, null, w5 }, { w6, w7, w8 } };
		TileSet tiles = new TileSet();
		Puzzle puzzle = new Puzzle(tiles);
		puzzle.setShape(winShape);
		m.setPuzzle(puzzle);

		FlipTileController controller = new FlipTileController(app, m);
		controller.mousePressed(new Point(0, 0));

		assertTrue(m.getWin());
	}

	@Test
	void testLoseConfig() {
		Model m = new Model();
		Application app = new Application(m);

		Rectangle r = new Rectangle(0, 0, 0, 0);
		Tile l1 = new Tile("1", "0", r, false);
		Tile l2 = new Tile("4", "0", r, false);
		Tile l3 = new Tile("1", "0", r, false);
		Tile l4 = new Tile("4", "0", r, false);
		Tile l5 = new Tile("1", "0", r, false);
		Tile l6 = new Tile("4", "0", r, false);
		Tile l7 = new Tile("1", "0", r, false);
		Tile l8 = new Tile("4", "0", r, false);

		final Tile[][] loseShape = { { l1, l4, null }, { l2, l5, l7 }, { l3, l6, l8 } };
		TileSet tiles = new TileSet();
		Puzzle p = new Puzzle(tiles);
		p.setShape(loseShape);
		m.setPuzzle(p);

		FlipTileController controller = new FlipTileController(app, m);
		controller.mousePressed(new Point(0, 0));

		assertTrue(m.getLose());
	}
}