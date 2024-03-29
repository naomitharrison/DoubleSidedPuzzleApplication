package starter.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import starter.controller.ExitApplicationController;
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
import java.awt.event.WindowEvent;
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


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (model == null) {return; }
		
		Puzzle puzzle = model.getPuzzle();
		TileSet tileSet = puzzle.getTileSet();
		ArrayList<Tile> tiles = tileSet.getAllTiles();
		
		// draw the rectangle and visible digit for each tile
		for(int i=0; i<tiles.size();i++) {
			Tile tile = tiles.get(i);
			Rectangle r = tile.getRectangle();
			boolean blackBackground = tile.getFlipped();
			g.setFont(new Font("default", Font.BOLD, 32));
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
		
		//display winning or losing message
		if(model.getWin()) {
			Rectangle r = new Rectangle(125,175,350,250);
			g.setColor(Color.BLUE);
			g.fillRect(r.x, r.y, r.width, r.height);
			g.setFont(new Font("default", Font.BOLD, 60));
			g.setColor(Color.RED);
			g.drawString("YOU WIN", 150, 300);
			g.setFont(new Font("default", Font.BOLD, 16));
			g.setColor(Color.WHITE);
			g.drawString("Click Anywhere to Reset Game", 150, 350);
		}
		if(model.getLose()) {
			Rectangle r = new Rectangle(125,175,350,250);
			g.setColor(Color.BLUE);
			g.fillRect(r.x, r.y, r.width, r.height);
			g.setFont(new Font("default", Font.BOLD, 60));
			g.setColor(Color.RED);
			g.drawString("YOU LOSE", 150, 300);
			g.setFont(new Font("default", Font.BOLD, 16));
			g.setColor(Color.WHITE);
			g.drawString("Click Anywhere to Reset Game", 150, 350);
		}
	}
}
