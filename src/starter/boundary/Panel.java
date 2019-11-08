package starter.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import starter.controller.ResetController;
import starter.entity.Model;
import starter.entity.Puzzle;
import starter.entity.Tile;
import starter.entity.TileSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Panel extends JPanel {
	
	Model model;
	
	public Panel(Model m) {
		this.model = m;
	}

	/**
	 * Create the panel.
	 */
	public Panel() {
		Puzzle puzzle = model.getPuzzle();
		int moves = puzzle.getMoves();
		
		JButton btnReset = new JButton("Reset");
		
		JLabel lblNoOfMoves = new JLabel("No. Of Moves: "+moves);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnReset)
					.addPreferredGap(ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
					.addComponent(lblNoOfMoves)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoOfMoves)
						.addComponent(btnReset))
					.addContainerGap(262, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		

	}


	@Override
	public void paintComponent(Graphics g) {
		Puzzle puzzle = model.getPuzzle();
		TileSet tileSet = puzzle.getTileSet();
		ArrayList<Tile> tiles = tileSet.getAllTiles();
		
		// draw the rectangle and visible digit for each tile
		for(int i=0; i<tiles.size();i++) {
			Tile tile = tiles.get(i);
			Rectangle r = tile.getRectangle();
			boolean blackBackground = tile.getFlipped();
			g.setFont(new Font("default", Font.BOLD, 16));
			if(blackBackground) {
				g.fillRect(r.x, r.y, r.width, r.height);
				g.setColor(Color.WHITE);
				g.drawString(tile.getVisibleDigit(), (int) r.getCenterX(), (int) r.getCenterY());
				g.setColor(Color.BLACK);
			}
			else {
				g.drawString(tile.getVisibleDigit(), (int) r.getCenterX(), (int) r.getCenterY());
				g.drawRect(r.x, r.y, r.width, r.height);
			}			
		}

	}
}
