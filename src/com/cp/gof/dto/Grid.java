package com.cp.gof.dto;

public class Grid {
	public static final int DEFAULT_ROWS = 25;
	  public static final int DEFAULT_COLS = 25;

	  private int rows;
	  private int cols;
	  private boolean[][] cells;
	  private int generation;
	  
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public boolean[][] getCells() {
		return cells;
	}
	public void setCells(boolean[][] cells) {
		this.cells = cells;
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public Grid() {
		this.rows = DEFAULT_ROWS;
		this.cols = DEFAULT_COLS;
		defaultGrid();
	}
	
	private void defaultGrid(){
		setDefaultValuetoAllCellsAsFalse();
		initializeWithGliderPattern();
  }

	  private void setDefaultValuetoAllCellsAsFalse(){
			cells = new boolean[this.rows][cols];
			for(int i = 0; i < rows; i++){
				  for(int j = 0; j < cols; j++){
						cells[i][j] = false;
				  }
			}
	  }
	  
	  private void initializeWithGliderPattern(){
		  /** identify the mid of the grid**/
		  int r = this.rows/2;
			int c = this.cols/2;

			cells[r-1][c] = true;
			cells[r][c+1] = true;
			cells[r+1][c+1] = true;
			cells[r+1][c] = true;
			cells[r+1][c-1] = true;
	  }
	  
}
