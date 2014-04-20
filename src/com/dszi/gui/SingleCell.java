package com.dszi.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.dszi.firstorderlogic.Properties;

import javax.swing.JPanel;

public class SingleCell extends JPanel {

	private static final long serialVersionUID = 5121081628171676849L;
	private Color defaultBackground;
	Properties Props = new Properties();
	
	int irrigation, soilDestruction, numberOfPests;

	public SingleCell() {
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
	
	public void refreshGroundParameters() {
		String toolTip = "<html>Nawodnienie : " + getIrrigation() + "% | " + 
						 "Zniszczenie gleby : " + getSoilDestruction() + "% | " +
						 "Liczba szkodników : " + getNumberOfPests() + " <br>";
		
		toolTip = toolTip + 
				 "Czy wymaga podlania: " + Props.NeedsWatering(this) + "<br>" +
				 "Czy wymaga nawo¿enia: " + Props.NeedsFertilising(this) + "<br>" +
				 "Czy ma insekty: " + Props.SomePestsPresent(this) + "</html>" //+
				 /*"DEV: Nawodnienie jako substring " + irrigation + " " +
				 "DEV: Nawodnienie jako liczba " + Irrigation + " " +
				 "DEV: U¿yŸnienie jako liczba " + soilDestruction + " " +
				 "DEV: Insekty jako liczba " + numberofPests + " "*/;
		
		setToolTipText(toolTip);
	}
	
	public int getIrrigation() {
		return irrigation;
	}

	public void setIrrigation(int irrigation) {
		this.irrigation = irrigation;
	}

	public int getSoilDestruction() {
		return soilDestruction;
	}

	public void setSoilDestruction(int soilDestruction) {
		this.soilDestruction = soilDestruction;
	}

	public int getNumberOfPests() {
		return numberOfPests;
	}

	public void setNumberofPests(int numberofPests) {
		this.numberOfPests = numberofPests;
	}

	public void setTractorPositionHere() {
		setBackground(Color.RED);
	}
	
	public void setTractorPositionWhenLeaving() {
		setBackground(Color.BLUE);
	}
	
	public void setClearCellHere() {
		setBackground(defaultBackground);
	}
	
	public void setAlgoritmPositionHere() {
		setBackground(Color.GREEN);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(50, 50);
	}
}