package io.pleo.assignment.model;

public class Cell {

	public static final int EMPTY = 0;
	public static final int BLOCK = 1;
	public static final int WATER = 2;

	private int content;

	public Cell(int content) {
		this.content = content;
	}

	public boolean isEmpty(){
		return !isWater() && !isBlock();
	}

	public boolean isBlock() {
		return content == BLOCK;
	}

	public boolean isWater() {
		return content == WATER;
	}

	public void water(){
		content = WATER;
	}

	public int content() {
		return content;
	}
}
