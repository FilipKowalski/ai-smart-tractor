package com.dszi.gui;

import java.util.TimerTask;

public class TractorMovement extends TimerTask {
	
	SingleCell cellPanel[] = new SingleCell[144];
	int position = 1;
	
	public TractorMovement(SingleCell cellPanel[]) {
		this.cellPanel = cellPanel;
		position = 1;
	}
	
    public void run() {
    	setTractorPosition(position);
    }
    
    private void setTractorPosition(int i) {
		cellPanel[i - 1].setTractorPositionWhenLeaving();
		cellPanel[i].setTractorPositionHere();
		position++;
	}
}
