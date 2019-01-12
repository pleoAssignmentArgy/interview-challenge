package io.pleo.assignment.model;

import java.util.Arrays;

import static io.pleo.assignment.model.Cell.BLOCK;
import static io.pleo.assignment.model.Cell.EMPTY;

public class Terrain {

	private Cell[][] nodes;

	public Terrain(int[] input) {

		int numOfColumns = input.length;
		int numOfRows = maxElement(input);

		nodes = emptyTerrain(numOfColumns, numOfRows);

		initialiseTerrain(input);
	}

	private void initialiseTerrain(int[] input) {
		int numOfColumns = input.length;
		for (int i = 0; i < numOfColumns; i++) {
			int numOfBlocks = input[i];
			for (int j = 0; j < numOfBlocks; j++) {
				nodes[i][j] = new Cell(BLOCK);
			}
		}
	}

	static Cell[][] emptyTerrain(int numOfColumns, int numOfRows) {
		Cell[][] result = new Cell[numOfColumns][numOfRows];
		for (int i = 0; i < numOfColumns; i++) {
			for (int j = 0; j < numOfRows; j++) {
				result[i][j] = new Cell(EMPTY);
			}
		}
		return result;
	}

	public void rain() {
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[i].length; j++) {
			}
		}
	}


	private leastHeightCellAroundNode(int i, int j) {

	}

	public Cell[][] nodes() {
		return nodes;
	}

	private int maxElement(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

}
