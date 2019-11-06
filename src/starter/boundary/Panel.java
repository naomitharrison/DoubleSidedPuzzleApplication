package starter.boundary;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import starter.entity.Model;
import starter.entity.Tile;

public class Panel extends JPanel {
	
	Model model;
	
	public Panel(Model m) {
		this.model = m;
	}

	/**
	 * Create the panel.
	 */
	public Panel() {
			
	}
	
	@Override
	public void paintComponent(Graphics g) {
	//change display when stuff happens	
	}

}
