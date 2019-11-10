package starter.controller;

import starter.boundary.Application;
import starter.entity.Model;
import starter.entity.Puzzle;

public class ResetController {
	
	final Model model;
	final Application app;
	
	public ResetController(Application app,Model model) {
		this.model = model;
		this.app = app;
	}
	
	public void process() {
		model.resetPuzzle();
		model.resetStatus();
		Puzzle puzzle = model.getPuzzle();
		puzzle.resetMoves();
		int moves = puzzle.getMoves();
		app.getLabel().setText("No. Of Moves: "+moves);
		app.repaint();
	}
}
