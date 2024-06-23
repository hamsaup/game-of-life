package com.cp.gof.service;

import com.cp.gof.dto.Grid;

public class GameOfLifeRules {
	private Grid grid;
	private int rows;
	private int cols;
	
	public Grid getGrid(){
		return this.grid;
  }
	public GameOfLifeRules() {
		// initialize grid
		this.grid = new Grid();
		this.rows = this.grid.getRows();
		this.cols = this.grid.getCols();
	}

	public void nextGeneration() {
		boolean[][] nextGenCells = new boolean[rows][cols];
		// looping each cell
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				nextGenCells[i][j] = applyrulesForCurentCell(i, j);
			}
		}
		grid.setCells(nextGenCells);
		grid.setGeneration(this.grid.getGeneration()+1);
	}

	private boolean applyrulesForCurentCell(int row, int col) {
		boolean[][] currentGenCells = this.grid.getCells();
		boolean currentCellState = currentGenCells[row][col];
		boolean newCellState;
			// finding no Of Neighbours that are alive
			int liveNeighbors = countaliveNeighbors(currentGenCells,row, col);
			if ((currentCellState) && (liveNeighbors < 2))
				newCellState = false;

            // Cell dies due to over population
            else if ((currentCellState) && (liveNeighbors > 3))
            	newCellState = false;

            // A new cell is born
            else if ((!currentCellState) && (liveNeighbors == 3))
            	newCellState = true;

            // Remains the same
            else
            	newCellState = currentCellState;
		return newCellState;
	}
	private int countaliveNeighbors(boolean[][] currentGenCells,int x, int y) {
		int count=0;
		for (int i = -1; i < 2; i++) {
		    for (int j = -1; j < 2; j++) {
		    	/**x+i and y+i values of cell (relative position)
		    	 * corner cells will wrap around and take their neighours
		    	 */
		    	int col = (x + i + cols) % cols;
		        int row = (y + j + rows) % rows;
		        count += currentGenCells[col][row] ? 1:0;
		    	}
		}
		//remove current one
		count -= currentGenCells[x][y]? 1:0;
		return count;
	}
}
