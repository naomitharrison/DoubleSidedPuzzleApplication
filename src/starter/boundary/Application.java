package starter.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import starter.controller.FlipTileController;
import starter.controller.ResetController;
import starter.entity.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class Application extends JFrame {

	private JPanel contentPane;
	Panel panel;
	
	Model model;
	JLabel lblNl;
	
	Application app = this;
	
	public Panel getPanel() {
		return panel;
	}

	/**
	 * Create the frame.
	 */
	public Application(Model m) {
		this.model = m; 
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new Panel(model);
	
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				 new FlipTileController(Application.this, model).mousePressed(me.getPoint());
			}
		});
		panel.setVisible(true);
		
		JButton btnR = new JButton("Reset");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ResetController(app,model).process();
			}
		});
		
	    lblNl = new JLabel("No. Of Moves: "+ 0);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnR)
							.addPreferredGap(ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
							.addComponent(lblNl)
							.addGap(185))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnR)
						.addComponent(lblNl))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public JLabel getLabel() {
		return lblNl;
	}
}
