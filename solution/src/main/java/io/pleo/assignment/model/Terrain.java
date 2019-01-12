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

	Terrain(Cell[][] cells) {
		this.cells = cells;
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
		for (int column = 0; column < numOfColumns; column++) {
			for (int row = 0; row < numOfRows; row++) {
				result[column][row] = new Cell(new Coordinates(column, row), EMPTY);
			}
		}
		return result;
	}

	public void rain() {

		for (int column = 0; column < cells.length; column++) {
			for (int row = cells[column].length - 1; row > 0; row--) {
				Cell current = cells[column][row];
				if (current.isBlock() || current.isWater()) {
					Cell shortestNeighbor = findShortestNeighborForCell(current);
					if (shortestNeighbor != null) {
						if (shortestNeighbor.isEmpty()) {
							shortestNeighbor.water();
						}
					}
				}
			}
		}
	}


	public void print() {
		for (int column = 0; column < cells.length; column++) {
			for (int row = 0; row < cells[column].length; row++) {
				System.out.print(cells[column][row]);
			}
			System.out.println();
		}
	}

	public int countWaterUnits() {
		int result = 0;
		for (int column = 0; column < cells.length; column++) {
			for (int row = 0; row < cells[column].length; row++) {
				if (cells[column][row].isWater()) {
					result++;
				}
			}
		}
		return result;
	}

	Cell findShortestNeighborForCell(Cell cell) {
		int cellRow = cell.coordinates().row();
		int cellColumn = cell.coordinates().column();

		for (int row = 0; row < cellRow; row++) {
			int columnLeft = cellColumn - 1;
			int columnRight = cellColumn + 1;
			int rowDown = row - 1;

			if (rowDown >= 0) {
				if (columnLeft >= 0 && cells[columnLeft][rowDown].isEmpty()) { //avoid index out of bounds
					return cells[columnLeft][rowDown];
				} else if (columnRight <= cells.length - 1 && cells[columnRight][rowDown].isEmpty()) { //avoid index out of bounds
					return cells[columnRight][rowDown];
				}
			}
		}
		return null;
	}


	public Cell[][] cells() {
		return cells;
	}

	private int maxElement(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

}
