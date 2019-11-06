package starter.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import starter.controller.FlipTileController;
import starter.entity.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Application extends JFrame {

	private JPanel contentPane;
	Panel panel;
	
	Model model;
	
	public Panel getPanel() {
		return panel;
	}

	/**
	 * Create the frame.
	 */
	public Application(Model m) {
		this.model = m;
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 419, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new Panel(model);
		FlipTileController fpc = new FlipTileController(this, model);
		panel.addMouseListener(fpc);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
