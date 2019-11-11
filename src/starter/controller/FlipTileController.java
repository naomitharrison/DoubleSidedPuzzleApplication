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

public class FlipTileController { //this is a java mouse listener
	
	final Application app;
	final Model model;
	
	public FlipTileController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void mousePressed(Point p) {
		if(model.getLose()||model.getWin()) {
			new ResetController(app,model).process();
		}
		// if mouse is clicked in a tile adjacent to empty space
//		Point p = me.getPoint();
		Puzzle puzzle = model.getPuzzle();
		ArrayList<Tile> movableTiles = puzzle.movableTiles();
		Tile clickedTile = null;
		for(int i=0; i<movableTiles.size(); i++) {
			Tile t = movableTiles.get(i);
			Rectangle r = t.getRectangle();
			if(r.contains(p)) {
				clickedTile = t;
			}
		}
		// flip tile, add one move, and refresh display
		if(clickedTile != null) {
			puzzle.updatePuzzle(clickedTile);
			puzzle.addOneMove();
			int moves = puzzle.getMoves();
			app.getLabel().setText("No. Of Moves: "+moves);
		}
		boolean win = puzzle.checkWin();
		boolean lose = puzzle.checkLose();
		
		if(win) {
			model.setStatus(true,false);
			app.repaint();
		}
		if(lose) {
			model.setStatus(false,true);
			app.repaint();
		}
		app.repaint();
	}

}
