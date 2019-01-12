package io.pleo.assignment.model;

import java.util.Arrays;

import static io.pleo.assignment.model.Node.BLOCK;
import static io.pleo.assignment.model.Node.EMPTY;

public class Terrain {

	private Node[][] nodes;

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
				nodes[i][j] = new Node(BLOCK);
			}
		}
	}

	static Node[][] emptyTerrain(int numOfColumns, int numOfRows) {
		Node[][] result = new Node[numOfColumns][numOfRows];
		for (int i = 0; i < numOfColumns; i++) {
			for (int j = 0; j < numOfRows; j++) {
				result[i][j] = new Node(EMPTY);
			}
		}
		return result;
	}

	public void rain() {
//		for (int i = 0; i < nodes.length; i++) {
//			for (int j = 0; j < nodes[i].length; j++) {
//				if(nodes[i][j].isEmpty()){
//					nodes[i][j].water();
//				}
//			}
//		}
	}

	public Node[][] nodes() {
		return nodes;
	}

	private int maxElement(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

}
