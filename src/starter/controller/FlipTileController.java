package starter.controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import starter.entity.Model;
import starter.entity.Puzzle;
import starter.entity.Tile;
import starter.boundary.Application;
import starter.boundary.Panel;

public class FlipTileController extends MouseAdapter { //this is a java mouse listener
	
	final Application app;
	final Model model;
	
	public FlipTileController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		// if mouse is clicked
		Point p = me.getPoint();
		
		// in a tile adjacent to empty space
		Puzzle puzzle = model.getPuzzle();
		ArrayList<Tile> movableTiles = puzzle.movableTiles();
		Tile clickedTile;
		for(int i=0; i<movableTiles.size(); i++) {
			Tile t = movableTiles.get(i);
			Rectangle r = t.getRectangle();
			if(r.contains(p)) {
				clickedTile = t;
			}
		}
		
		// flip clicked tile
		// update puzzle
		// refresh display
		

//		Tile tile = model.getTile();
//		Rectangle r = tile.getRectangle();
//		Point p = me.getPoint();
//		if (r.contains(p)) {
//			tile.flip();
//			panel pp = app.getPanel();
//			
//			int newx = (int) (rnd.nextDouble() + (pp.getWidth() - 100));
//			int newy = (int) (rnd.nextDouble() + (pp.getHeight() - 100));
//			Rectangle newRect = new Rectangle(newx,newy,100, 100);
//			tile.setLocation(newRect);
//			app.repaint();
//		}
	}

}
