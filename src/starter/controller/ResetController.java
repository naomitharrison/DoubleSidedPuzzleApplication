package starter.controller;

import java.awt.event.MouseEvent;

import starter.boundary.Application;
import starter.entity.Model;
import starter.entity.Puzzle;

public class ResetController {
	
	final Application app;
	final Model model;
	
	public ResetController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	public void buttonPressed(MouseEvent me) {
		Puzzle puzzle = model.getPuzzle();

		
		app.repaint();
	}
}
