package com.dszi.gui;


import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;


public class MainView {

	public MainView() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}
				
				JTextField field1 = new JTextField("Pole 1");
				JTextField field2 = new JTextField("Pole 2");
				JButton generate = new JButton("Generate");
				
				JFrame frame = new JFrame("iTractor");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new MigLayout());
				frame.add(field1, "width 100:250:300, cell 0 0");
				frame.add(field2, "width 100:250:300, cell 1 0 2 1");
				frame.add(generate, "cell 3 0");
				frame.add(new GridPanel(), "cell 0 1 4 1");
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}