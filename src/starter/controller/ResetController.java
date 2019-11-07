package starter.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import starter.boundary.Application;
import starter.entity.Model;
import starter.entity.Puzzle;

public class ResetController extends AbstractAction {
	
	final Application app;
	final Model model;
	
	public ResetController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Puzzle puzzle = model.getPuzzle();
		puzzle.resetPuzzle();		
		app.repaint();
	}
}
