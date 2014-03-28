package com.dszi.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import com.dszi.randomizer.RandomGroundGenerator;

public class GridPanel extends JPanel {

	private static final long serialVersionUID = -3216361759473038176L;
	SingleCell cellPanel[] = new SingleCell[144];

	public GridPanel() {
		initializeGridView();
		initializeTractorPosition();
		initializeGeneratedData();
	}
	
	private void initializeGridView() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		int counter = 0;
		for (int row = 0; row < 12; row++) {
			for (int col = 0; col < 12; col++) {
				gbc.gridx = col;
				gbc.gridy = row;

				cellPanel[counter] = new SingleCell();
				Border border = null;
				border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
				cellPanel[counter].setBorder(border);
				add(cellPanel[counter], gbc);
				
				counter++;
			}
		}
	}
	
	private void initializeTractorPosition() {
		cellPanel[0].setTractorPositionHere();
	}
	
	private void initializeGeneratedData() {
		for (int i = 0; i < 144; i++) {
			cellPanel[i].setGroundParameters(RandomGroundGenerator.generateIrrigation(), 
					RandomGroundGenerator.generateSoilDesctruction(), RandomGroundGenerator.generateNumberOfPests());
		}
	}
}