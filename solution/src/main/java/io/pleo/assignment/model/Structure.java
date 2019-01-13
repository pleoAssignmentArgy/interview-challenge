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

	private int maxElement(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

	Structure(Cell[][] cells) {
		this.cells = cells;
	}

	private void initialiseStructure(int[] input) {
		int numOfColumns = input.length;
		for (int i = 0; i < numOfColumns; i++) {
			int numOfBlocks = input[i];
			for (int j = 0; j < numOfBlocks; j++) {
				cells[i][j].content(BLOCK);
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
		int maxRowNumber = cells[0].length;
		for (int row = 0; row < maxRowNumber; row++) {
			fillWithWater(row);
		}
	}

	private void fillWithWater(int row) {
		for (int column = 0; column < cells.length - 1; column++) {
			Cell firstBlockCandidate = cells[column][row];

			if (firstBlockCandidate.isBlock()) {
				for (int column2 = firstBlockCandidate.coordinates().column(); column2 < cells.length; column2++) {

					Cell emptyCandidate = cells[column2][row];
					if (emptyCandidate.isEmpty()) {
						for (int column3 = emptyCandidate.coordinates().column(); column3 < cells.length; column3++) {
							Cell secondBlockCandidate = cells[column3][row];
							if (secondBlockCandidate.isBlock()) {
								coverWithWaterEmptyInBetween(firstBlockCandidate, secondBlockCandidate);
								firstBlockCandidate = secondBlockCandidate;
							}
						}
					}
				}
			}
		}
	}

	private void coverWithWaterEmptyInBetween(Cell firstBlockCandidate, Cell secondBlockCandidate) {
		int row = firstBlockCandidate.coordinates().row();

		int leftColumn = firstBlockCandidate.coordinates().column();
		int rightColumn = secondBlockCandidate.coordinates().column();

		for (int i = leftColumn; i < rightColumn; i++) {

			if(columnContainsHole(i)){
				return;
			}

			if (cells[i][row].isEmpty()) {
				cells[i][row].water();
			}
		}
	}

	private boolean columnContainsHole(int column) {
		return cells[column][0].isEmpty();
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

}
