package io.pleo.assignment.model;

import java.util.Arrays;

import static io.pleo.assignment.model.Node.BLOCK;
import static io.pleo.assignment.model.Node.EMPTY;

public class Terrain {

	private static Node[][] nodes;

	public Terrain(int[] input) {
		nodes = emptyTerrain(maxElement(input), input.length);
		for (int i = 0; i < input.length; i++) {
			int numOfBlocks = input[i];
			for (int j = 0; j < numOfBlocks; j++) {
				nodes[i][j] = new Node(BLOCK);
			}
		}
	}

	private int maxElement(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

	public static Node[][] emptyTerrain(int numOfColumns, int numOfRows) {

		Node[][] result = new Node[numOfColumns][numOfRows];
		for (int i = 0; i < numOfColumns; i++) {
			for (int j = 0; j < numOfRows; j++) {
				result[i][j] = new Node(EMPTY);
			}
		}

		return result;
	}

	public void rain() {

	}
}
