package com.dszi.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class TestPane extends JPanel {

	private static final long serialVersionUID = -3216361759473038176L;

	public TestPane() {
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		for (int row = 0; row < 12; row++) {
			for (int col = 0; col < 12; col++) {
				gbc.gridx = col;
				gbc.gridy = row;

				CellPane cellPane = new CellPane();
				Border border = null;
				if (row < 4) {
					if (col < 4) {
						border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
					} else {
						border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
					}
				} else {
					if (col < 4) {
						border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
					} else {
						border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
					}
				}
				cellPane.setBorder(border);
				add(cellPane, gbc);
			}
		}
	}
}