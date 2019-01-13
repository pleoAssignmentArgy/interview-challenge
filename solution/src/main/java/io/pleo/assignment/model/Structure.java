package io.pleo.assignment.model;

import java.util.Arrays;

import static io.pleo.assignment.model.Cell.BLOCK;
import static io.pleo.assignment.model.Cell.EMPTY;

public class Structure {

	private Cell[][] cells;

	public Structure(int[] input) {

		int numOfColumns = input.length;
		int numOfRows = maxElement(input);

		cells = emptyStructure(numOfColumns, numOfRows);

		initialiseStructure(input);
	}

	Structure(Cell[][] cells) {
		this.cells = cells;
	}

	private void initialiseStructure(int[] input) {
		int numOfColumns = input.length;
		for (int i = 0; i < numOfColumns; i++) {
			int numOfBlocks = input[i];
			for (int j = 0; j < numOfBlocks; j++) {
				cells[i][j] = new Cell(new Coordinates(i, j), BLOCK);
			}
		}
	}

	static Cell[][] emptyStructure(int numOfColumns, int numOfRows) {
		Cell[][] result = new Cell[numOfColumns][numOfRows];
		for (int column = 0; column < numOfColumns; column++) {
			for (int row = 0; row < numOfRows; row++) {
				result[column][row] = new Cell(new Coordinates(column, row), EMPTY);
			}
		}
		return result;
	}


	public void rain() {
		int maxRows = maxColumn();
		for (int row = 0; row < maxRows; row++) {
			fillWithWater(row);
		}
	}

	private void fillWithWater(int row) {
		for (int column = 0; column < maxColumn(); column++) {
			Cell firstBlockCandidate = cells[column][row];

			if (firstBlockCandidate.isBlock()) {
				for (int column2 = column; column2 < maxColumn(); column2++) {

					Cell emptyCandidate = cells[column2][row];

					if (emptyCandidate.isEmpty()) {
						for (int column3 = column2; column3 < maxColumn(); column3++) {
							Cell secondBlockCandidate = cells[column3][row];
							if (secondBlockCandidate.isBlock()) {
								coverWithWaterEmptyInBetween(firstBlockCandidate, secondBlockCandidate);
							}
						}
					}
				}
			}
		}
	}

	private int maxColumn() {
		return cells[0].length;
	}

	private void coverWithWaterEmptyInBetween(Cell firstBlockCandidate, Cell secondBlockCandidate) {
		int row = firstBlockCandidate.coordinates().row();

		int leftColumn = firstBlockCandidate.coordinates().column();
		int rightColumn = secondBlockCandidate.coordinates().column();
		System.out.println("Watering row " + row + ", bw columns " + leftColumn + " and " + rightColumn);

		for (int i = leftColumn; i < rightColumn; i++) {
			if (cells[i][row].isEmpty()) {
				cells[i][row].water();
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


	public Cell[][] cells() {
		return cells;
	}

	private int maxElement(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

}
