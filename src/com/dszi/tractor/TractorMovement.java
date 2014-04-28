package com.dszi.tractor;

import java.util.TimerTask;

import com.dszi.gui.SingleCell;
import com.dszi.support.Constants;

public class TractorMovement extends TimerTask {

	SingleCell cellPanel[][] = new SingleCell[Constants.gridSizeX][Constants.gridSizeY];
	int positionX = 1;
	int positionY = 1;

	public TractorMovement(SingleCell cellPanel[][]) {
		this.cellPanel = cellPanel;
	}

	public void run() {
		setTractorPosition(positionX, positionY);
	}

	private void setTractorPosition(int x, int y) {
		cellPanel[x - 1][y].setTractorPositionWhenLeaving();
		cellPanel[x][y].setTractorPositionHere();
		positionX++;
	}
}
