package starter;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import starter.boundary.Application;
import starter.controller.ExitApplicationController;
import starter.entity.Model;
import starter.entity.Puzzle;
import starter.entity.Tile;
import starter.entity.TileSet;

public class Main {
	public static void main (String[] args) {
		Model model = new Model();
		TileSet tiles = new TileSet();
		Puzzle puzzle = new Puzzle(tiles);
		
		model.setPuzzle(puzzle);
		
		Application app = new Application(model);
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e ) {
				new ExitApplicationController(app).process();
			}
		});
		
		app.setVisible(true);
		
	}

}
