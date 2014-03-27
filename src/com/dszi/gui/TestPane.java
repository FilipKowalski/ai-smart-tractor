package com.dszi.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class TestPane extends JPanel {

	private static final long serialVersionUID = -3216361759473038176L;
	int counter = 0;
	CellPanel cellPanel[] = new CellPanel[144];

	public TestPane() {
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		for (int row = 0; row < 12; row++) {
			for (int col = 0; col < 12; col++) {
				gbc.gridx = col;
				gbc.gridy = row;

				cellPanel[counter] = new CellPanel();
				Border border = null;
				border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
				cellPanel[counter].setBorder(border);
				add(cellPanel[counter], gbc);
				
				counter++;
			}
		}
		cellPanel[0].setTractorPositionHere();
	}
}