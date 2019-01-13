package io.pleo.assignment.model;

import java.util.Arrays;

import static io.pleo.assignment.model.Cell.BLOCK;
import static io.pleo.assignment.model.Cell.EMPTY;

public class Structure {

	private Cell[][] cells;

	private static int NUM_OF_COLUMNS;
	private static int NUM_OF_ROWS;

	public Structure(int[] input) {
		NUM_OF_COLUMNS = input.length;
		NUM_OF_ROWS = maxElement(input);

		cells = emptyStructure(NUM_OF_COLUMNS, NUM_OF_ROWS);
		initialiseStructure(input);
	}

	private int maxElement(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

	Structure(Cell[][] cells) {
		NUM_OF_ROWS = cells[0].length;
		NUM_OF_COLUMNS = cells.length;
		this.cells = cells;
	}

	private void initialiseStructure(int[] input) {
		for (int i = 0; i < NUM_OF_COLUMNS; i++) {
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
		for (int row = 0; row < NUM_OF_ROWS; row++) {
			fillWithWater(row);
		}
	}

	private void fillWithWater(int row) {
		for (int column = 0; column < NUM_OF_COLUMNS; column++) {
			Cell firstBlockCandidate = cells[column][row];

			if (firstBlockCandidate.isBlock()) {
				for (int column2 = firstBlockCandidate.coordinates().column(); column2 < NUM_OF_COLUMNS; column2++) {

					Cell emptyCandidate = cells[column2][row];
					if (emptyCandidate.isEmpty()) {
						for (int column3 = emptyCandidate.coordinates().column(); column3 < NUM_OF_COLUMNS; column3++) {
							Cell secondBlockCandidate = cells[column3][row];
							if (secondBlockCandidate.isBlock()) {
								coverWithWaterEmptyCellsBetween(firstBlockCandidate, secondBlockCandidate);
								firstBlockCandidate = secondBlockCandidate;
							}
						}
					}
				}
			}
		}
	}

	private void coverWithWaterEmptyCellsBetween(Cell firstBlockCandidate, Cell secondBlockCandidate) {
		int row = firstBlockCandidate.coordinates().row();

		int leftColumn = firstBlockCandidate.coordinates().column();
		int rightColumn = secondBlockCandidate.coordinates().column();

		for (int i = leftColumn; i <= rightColumn; i++) {
			if (columnContainsHole(i)) {
				return;
			} else if (cells[i][row].isEmpty()) {
				cells[i][row].water();
			}
		}
	}

	private boolean columnContainsHole(int column) {
		return cells[column][0].isEmpty();
	}

	public void print() {
		System.out.println("Structure: ");
		System.out.println("-----------");
		for (int column = 0; column < NUM_OF_COLUMNS; column++) {
			for (int row = 0; row < NUM_OF_ROWS; row++) {
				System.out.print(cells[column][row]);
			}
			System.out.println();
		}
		System.out.println("-----------");
	}

	public int countWaterUnits() {
		int waterUnits = 0;
		for (int column = 0; column < NUM_OF_COLUMNS; column++) {
			for (int row = 0; row < NUM_OF_ROWS; row++) {
				if (cells[column][row].isWater()) {
					waterUnits++;
				}
			}
		}
		return waterUnits;
	}


	public Cell[][] cells() {
		return cells;
	}

}
