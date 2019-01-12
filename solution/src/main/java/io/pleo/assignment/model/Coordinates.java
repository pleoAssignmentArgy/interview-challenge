package io.pleo.assignment.model;

public class Coordinates {

	private final int row;
	private final int column;

	public Coordinates(int column, int row) {
		this.column = column;
		this.row = row;
	}

	public int row() {
		return row;
	}

	public int column() {
		return column;
	}
}
