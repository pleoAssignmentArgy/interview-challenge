package io.pleo.assignment.model;

import java.util.Arrays;

import static io.pleo.assignment.model.Cell.BLOCK;
import static io.pleo.assignment.model.Cell.EMPTY;

public class Terrain {

	private Cell[][] cells;

	public Terrain(int[] input) {

		int numOfColumns = input.length;
		int numOfRows = maxElement(input);

		cells = emptyTerrain(numOfColumns, numOfRows);

		initialiseTerrain(input);
	}

	private void initialiseTerrain(int[] input) {
		int numOfColumns = input.length;
		for (int i = 0; i < numOfColumns; i++) {
			int numOfBlocks = input[i];
			for (int j = 0; j < numOfBlocks; j++) {
				cells[i][j] = new Cell(new Coordinates(i, j), BLOCK);
			}
		}
	}

	static Cell[][] emptyTerrain(int numOfColumns, int numOfRows) {
		Cell[][] result = new Cell[numOfColumns][numOfRows];
		for (int i = 0; i < numOfColumns; i++) {
			for (int j = 0; j < numOfRows; j++) {
				result[i][j] = new Cell(new Coordinates(i, j), EMPTY);
			}
		}
		return result;
	}

	public void rain() {
		for (int i = 0; i < cells.length; i++) {
			for(int j = 0; j<cells[i].length ; j++){
				Cell shortestNeighbor = findShortestNeighborForCell(cells[i][j]);
				if (shortestNeighbor.isEmpty()) {
					shortestNeighbor.water();
				}
			}
		}
	}

	Cell findShortestNeighborForCell(Cell cell) {
		int cellRow = cell.coordinates().row();
		int cellColumn = cell.coordinates().column();

		for (int i = 0; i < cellRow; i++) {

			int columnLeft = cellColumn - 1;
			int columnRight = cellColumn + 1;

			if (columnLeft >= 0 && cells[columnLeft][i].isEmpty()) { //avoid index out of bounds
				return cells[columnLeft][i];
			} else if (columnRight <= cells.length - 1 && cells[columnRight][i].isEmpty()) { //avoid index out of bounds
				return cells[columnRight][i];
			}
		}
		return cell;
	}


	public Cell[][] cells() {
		return cells;
	}

	private int maxElement(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

}
