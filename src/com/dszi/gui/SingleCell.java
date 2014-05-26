package com.dszi.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.dszi.firstorderlogic.Properties;
import com.dszi.logikaklauzul.LogicProperties;

public class SingleCell extends JPanel {

	private static final long serialVersionUID = 5121081628171676849L;
	private Color defaultBackground;
	
	int irrigation, soilDestruction, numberOfPests;

	public SingleCell() {
		initializeMouseListener();
	}

	private void initializeMouseListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				defaultBackground = getBackground();
				setBackground(new Color(100, 220, 100));
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
				 "Czy wymaga podlania: " + Properties.NeedsWatering(this) + "<br>" +
				 "Czy wymaga nawo¿enia: " + Properties.NeedsFertilising(this) + "<br>" +
				 "Czy ma insekty: " + Properties.SomePestsPresent(this) + "<br>" +
				 "Czy mo¿e zostaæ wykluczona: " + LogicProperties.GeneticAlgorithmMayRefuseThisCell(this) + "<br>" +
				 "Czy jest wykluczona/nie potrzebne naprawy: " + LogicProperties.TooGoodForGenetic(this) + "</html>";
		
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
		setBackground(new Color(150, 25, 100));
	}
	
	public void setTractorPositionWhenLeaving() {
		setBackground(new Color(70, 25, 5));
	}
	
	public void setClearCellHere() {
		setBackground(defaultBackground);
	}
	
	public void setAlgoritmPositionHere() {
		setBackground(new Color(120, 165, 100));
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(65, 65);
	}
}