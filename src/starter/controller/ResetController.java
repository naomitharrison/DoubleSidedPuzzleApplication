package starter.controller;

import starter.entity.Model;
import starter.entity.Puzzle;

public class ResetController {
	
	final Model model;
	
	public ResetController(Model model) {
		this.model = model;
	}
	
	public void process() {
		model.resetPuzzle();
		model.resetStatus();
	}
}
