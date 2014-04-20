package com.dszi.stateMethod;

import com.dszi.gui.SingleCell;
import com.dszi.support.Constants;
import com.dszi.tractor.Tractor;

public class DFS {

	Tractor tractor = new Tractor();
	SingleCell cellPanel[][] = new SingleCell[Constants.gridSizeX][Constants.gridSizeY];

	boolean[][] visited = new boolean[Constants.gridSizeX][Constants.gridSizeY]; 
	boolean hasToFinish = false;

	int positionX;
	int positionY;
	int waterLevel;
	int pesticideLevel;
	int fertilizerLevel;


	public DFS(SingleCell[][] cellPanel) {
		this.cellPanel = cellPanel;

		initializeTractor();
		runDfs();
	}

	public void runDfs() {
		dfs(0, 0);
	}

	private void dfs(int x, int y) {
		if(hasSupplies()) {
			calculateTractorResources(x, y);
			if (!visited[x + 1][y] && isNotOutOfBounds(x, y))
				dfs(x + 1, y);
			else if (!visited[x][y + 1] && isNotOutOfBounds(x, y))
				dfs(x, y + 1);
			else if (!visited[x - 1][y] && isNotOutOfBounds(x, y))
				dfs(x - 1, y);
			else if (!visited[x][y - 1] && isNotOutOfBounds(x, y))
				dfs(x, y - 1);
		}
	}

	private void initializeTractor() {
		this.positionX = tractor.getTractorPostionX();
		this.positionY = tractor.getTractorPositionY();
		this.waterLevel = tractor.getWaterLevel();
		this.pesticideLevel = tractor.getPesticideLevel();
		this.fertilizerLevel = tractor.getFertilizerLevel();
	}

	private void calculateTractorResources(int x, int y) {
		positionX = x;
		positionY = y;
		waterLevel = waterLevel - cellPanel[x][y].Irrigation;
		pesticideLevel = pesticideLevel - cellPanel[x][y].numberofPests;
		fertilizerLevel = fertilizerLevel - cellPanel[x][y].soilDestruction;
		visited[x][y] = true;
		cellPanel[x][y].setAlgoritmPositionHere();

		showResources();
	}

	private boolean hasSupplies() {
		if (waterLevel < 0 || pesticideLevel < 0 || fertilizerLevel < 0) 
			return false;
		return true;
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
		if(x >= 0 && y >= 0 && x <= Constants.gridSizeX && y <= Constants.gridSizeY)
			return true;
		return false;
	}
}
