package com.dszi.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import com.dszi.randomizer.RandomGroundGenerator;
import com.dszi.stateSpace.AAlgorithm;
import com.dszi.support.Constants;

@SuppressWarnings("serial")
public class GridPanel extends JPanel {

	SingleCell cellPanel[][] = new SingleCell[Constants.gridSizeX][Constants.gridSizeY];

	public GridPanel() {
		initializeGridView();
		initializeTractorPosition();
		initializeGeneratedData();
	}

	private void initializeGridView() {
		Border border = null;
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());

		for (int row = 0; row < Constants.gridSizeX; row++) {
			for (int col = 0; col < Constants.gridSizeY; col++) {
				gbc.gridx = col;
				gbc.gridy = row;

				cellPanel[row][col] = new SingleCell();
				border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
				cellPanel[row][col].setBorder(border);
				add(cellPanel[row][col], gbc);
			}
		}
	}

	public void clearGridView() {
		for (int row = 0; row < Constants.gridSizeX; row++) 
			for (int col = 0; col < Constants.gridSizeY; col++) 
				cellPanel[row][col].setClearCellHere();
	}

	private void initializeTractorPosition() {
		cellPanel[0][0].setTractorPositionHere();
	}

	public void initializeGeneratedData() {
		for (int i = 0; i < Constants.gridSizeX; i++) {
			for (int j = 0; j < Constants.gridSizeY; j++) {
				cellPanel[i][j].setIrrigation(RandomGroundGenerator.generateIrrigation());
				cellPanel[i][j].setSoilDestruction(RandomGroundGenerator.generateSoilDesctruction());
				cellPanel[i][j].setNumberofPests(RandomGroundGenerator.generateNumberOfPests());
				cellPanel[i][j].refreshGroundParameters();
			}
		}
	}

	public void startTractor() {
		//		Timer timer = new Timer();
		//		timer.schedule(new TractorMovement(cellPanel), 0, 100);
		AAlgorithm dfs = new AAlgorithm(cellPanel);
	}
}