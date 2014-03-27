package com.dszi.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class CellPanel extends JPanel {

	private static final long serialVersionUID = 5121081628171676849L;
	private Color defaultBackground;
	
	int id;

	public CellPanel() {
		initializeMouseListener();
	}

	private void initializeMouseListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				defaultBackground = getBackground();
				setBackground(Color.BLUE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(defaultBackground);
			}
		});
	}
	
	public void setTractorPositionHere() {
		setBackground(Color.RED);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(50, 50);
	}
}