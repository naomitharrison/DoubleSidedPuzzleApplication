package starter.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import starter.boundary.Application;
import starter.entity.Model;
import starter.entity.Puzzle;

public class ResetController extends AbstractAction {
	
	final Model model;
	
	public ResetController(Model model) {
		this.model = model;
		Puzzle puzzle = model.getPuzzle();
		puzzle.resetPuzzle();
		model.resetStatus();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Puzzle puzzle = model.getPuzzle();
		puzzle.resetPuzzle();
		model.resetStatus();
	}
}
