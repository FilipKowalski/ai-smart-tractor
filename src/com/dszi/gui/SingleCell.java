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
	
	public int Irrigation, soilDestruction, numberofPests;
	int id;

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
	
	public void setTractorPositionHere() {
		setBackground(Color.RED);
	}
	
	public void setGroundParameters(String irrigation, String soilDesctruction, String numberOfPests) {
		String toolTip = "Nawodnienie : " + irrigation + " " + 
						 "Zniszczenie gleby : " + soilDesctruction + " " +
						 "Liczba szkodników : " + numberOfPests + " ";
		
		if(irrigation.length()==2) irrigation = irrigation.substring(0, 1);
		if(irrigation.length()==3) irrigation = irrigation.substring(0, 2);
		if(irrigation.length()==4) irrigation = irrigation.substring(0, 3);
		if(soilDesctruction.length()==2) soilDesctruction = soilDesctruction.substring(0, 1);
		if(soilDesctruction.length()==3) soilDesctruction = soilDesctruction.substring(0, 2);
		if(soilDesctruction.length()==4) soilDesctruction = soilDesctruction.substring(0, 3);
		if(numberOfPests.length()==2) numberOfPests = numberOfPests.substring(0, 1);
		if(numberOfPests.length()==3) numberOfPests = numberOfPests.substring(0, 2);
		if(numberOfPests.length()==4) numberOfPests = numberOfPests.substring(0, 3);
		
		
		
		Irrigation = Integer.parseInt(irrigation);
		soilDestruction = Integer.parseInt(soilDesctruction);
		numberofPests = Integer.parseInt(numberOfPests);
		
		toolTip = toolTip + 
				 "Czy wymaga podlania: " + Props.NeedsWatering(this) + " " +
				 "Czy wymaga nawo¿enia: " + Props.NeedsFertilising(this) + " " +
				 "Czy ma insekty: " + Props.SomePestsPresent(this) + " " //+
				 /*"DEV: Nawodnienie jako substring " + irrigation + " " +
				 "DEV: Nawodnienie jako liczba " + Irrigation + " " +
				 "DEV: U¿yŸnienie jako liczba " + soilDestruction + " " +
				 "DEV: Insekty jako liczba " + numberofPests + " "*/;
		
		setToolTipText(toolTip);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(50, 50);
	}
}