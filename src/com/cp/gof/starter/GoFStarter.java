package com.cp.gof.starter;

import java.util.Scanner;

import com.cp.gof.dto.Grid;
import com.cp.gof.service.GameOfLifeRules;
import com.cp.gof.util.PrintGrid;

/**
 * This is the main class for running GameOfLife
 * - It checks the state of each cell and applies the rules
 * - Based on the rules new generation of cells are created
 */
public class GoFStarter {
	  public static void main(String[] args){
			GameOfLifeRules gameOfLife = new GameOfLifeRules();

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the number of generations:");
			int generations = scanner.nextInt();

			if(generations <= 0){
				  System.out.println("Number of generations must be greater than 0");
				  System.exit(-1);
			}

			// print initial state
			Grid grid = gameOfLife.getGrid();
			System.out.println("Initial state:");
			PrintGrid.outputValues(grid); // initial state

			// create generations
			for(int i = 1;i <= generations; i++){
				  gameOfLife.nextGeneration();
				  PrintGrid.outputValues(grid); // next generation
			}
	  }

}
