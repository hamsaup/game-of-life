package com.cp.gof.util;

import com.cp.gof.dto.Grid;

public class PrintGrid {
	public static void outputValues(Grid grid){
		System.out.println("\nGeneration = "+grid.getGeneration()+"\n");
		boolean[][] cells = grid.getCells();
		for(int i = 0; i< grid.getRows(); i++){
			  for(int j = 0; j<grid.getCols(); j++){
					int state = cells[i][j] ? 1 : 0;
					System.out.print(state+" ");
			  }
			  System.out.println();
		}
  }
}
