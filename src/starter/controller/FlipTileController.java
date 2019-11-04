package starter.controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import starter.entity.Model;
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
		Point p = me.getPoint();
		//if mouse is clicked in a tile adjacent to empty space, flip tile and refresh display
	}

}
