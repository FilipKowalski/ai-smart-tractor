package com.dszi.decision_tree;

import com.dszi.firstorderlogic.Properties;
import com.dszi.gui.SingleCell;
import com.dszi.support.Constants;
import com.dszi.tractor.Tractor;

public class TreeAlgorithm {

	Tractor tractor = new Tractor();
	SingleCell cellPanel[][] = new SingleCell[Constants.gridSizeX][Constants.gridSizeY];

	boolean[][] visited = new boolean[Constants.gridSizeX + 1][Constants.gridSizeY + 1]; 
	boolean hasToFinish = false;

	int positionX;
	int positionY;
	int waterLevel;
	int pesticideLevel;
	int fertilizerLevel;

	public TreeAlgorithm(SingleCell[][] cellPanel) {
		this.cellPanel = cellPanel;

		initializeTractor();
		dfs(0, 0);
	}

	public void dfs(int x, int y) {
		if(hasSupplies()) {
			calculateTractorResources(x, y);
			dfsChecker(x, y);
		}
	}

	private void dfsChecker(int x, int y) {
		int oldX = x;
		int oldY = y;
		int newX = x;
		int newY = y;

		if(isNotOutOfBounds(x + 1, y)) {
			if (!visited[x + 1][y]) {
				oldX = x + 1;
				oldY = y;
			} 
		}
		if(isNotOutOfBounds(x, y + 1)) {
			if (!visited[x][y + 1]) {
				newX = x;
				newY = y + 1;
				if(repairMostDamaged(oldX, oldY, newX, newY)) {
					oldX = newX;
					oldY = newY;
				}
			}
		}
		if(isNotOutOfBounds(x - 1, y)) {
			if (!visited[x - 1][y]) {
				newX = x - 1;
				newY = y;
				if(repairMostDamaged(oldX, oldY, newX, newY)) {
					oldX = newX;
					oldY = newY;
				}
			}
		}
		if(isNotOutOfBounds(x, y - 1)) {
			if (!visited[x][y - 1]) {
				newX = x;
				newY = y - 1;
				if(repairMostDamaged(oldX, oldY, newX, newY)) {
					oldX = newX;
					oldY = newY;
				}
			}
		}
		if(!visited[oldX][oldY])
			dfs(oldX, oldY);
	}

	private boolean repairMostDamaged(int oldX, int oldY, int newX, int newY) {
		int pointsForOld = 0;
		int pointsForNew = 0;

		if (Properties.IsinPerfectCondidion(cellPanel[newX][newY])) {
			pointsForOld = 1;
		}
		else {
			if (Properties.IsDead(cellPanel[newX][newY])) {
				pointsForNew = 1;
			} else {
				if (cellPanel[oldX][oldY].getIrrigation() <= cellPanel[newX][newY].getIrrigation()) {
					pointsForOld = 1;
				}
				else {
					if (cellPanel[oldX][oldY].getNumberOfPests() >= cellPanel[newX][newY].getNumberOfPests()) {
						pointsForOld = 1;
					}
					else {
						if (cellPanel[oldX][oldY].getSoilDestruction() >= cellPanel[newX][newY].getSoilDestruction()) 
							pointsForOld = 1;
						else pointsForNew = 1;
					}
				}
			}
		}
		if(pointsForOld >= pointsForNew) 
			return false;
		else return true;
	}

	private void calculateTractorResources(int x, int y) {
		positionX = x;
		positionY = y;
		waterLevel = waterLevel - cellPanel[x][y].getIrrigation();
		pesticideLevel = pesticideLevel - cellPanel[x][y].getNumberOfPests();
		fertilizerLevel = fertilizerLevel - cellPanel[x][y].getSoilDestruction();
		visited[x][y] = true;
		cellPanel[x][y].setAlgoritmPositionHere();

		updateCell(x, y);
		showResources();
	}

	private void updateCell(int x, int y) {
		cellPanel[x][y].setIrrigation(100);
		cellPanel[x][y].setNumberofPests(0);
		cellPanel[x][y].setSoilDestruction(0);
		cellPanel[x][y].refreshGroundParameters();
	}

	private boolean hasSupplies() {
		if (waterLevel < 0 || pesticideLevel < 0 || fertilizerLevel < 0) 
			return false;
		return true;
	}

	private void initializeTractor() {
		this.positionX = tractor.getTractorPostionX();
		this.positionY = tractor.getTractorPositionY();
		this.waterLevel = tractor.getWaterLevel();
		this.pesticideLevel = tractor.getPesticideLevel();
		this.fertilizerLevel = tractor.getFertilizerLevel();
	}

	private void showResources() {
		System.out.println("-----------------------");
		System.out.println("Sprawdzanie stanu pierwszej pozycji ");
		System.out.println("Aktualna pozycja : " + positionX + " " + positionY);
		System.out.println("Pozosta³e zasoby traktora : ");
		System.out.println("Woda " + waterLevel);
		System.out.println("Pestycydy " + pesticideLevel);
		System.out.println("Nawóz " + fertilizerLevel);
	}

	private boolean isNotOutOfBounds(int x, int y) {
		if(x >= 0 && y >= 0 && x < Constants.gridSizeX && y < Constants.gridSizeY)
			return true;
		return false;
	}


}
