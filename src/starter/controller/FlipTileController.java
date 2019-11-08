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

public class FlipTileController extends MouseAdapter { //this is a java mouse listener
	
	final Application app;
	final Model model;
	
	public FlipTileController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		// if mouse is clicked in a tile adjacent to empty space
		Point p = me.getPoint();
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
		}
		boolean win = puzzle.checkWin();
		boolean lose = puzzle.checkLose();
		System.out.println("win? "+win);
		System.out.println("lose? "+lose);
		if(win) {
			new StatusController(true,false);
			new ResetController(app,model);
		}
		if(lose) {
			new StatusController(false,true);
			new ResetController(app,model);
		}
		app.repaint();
	}

}
