package io.pleo.assignment.model;

public class Node {

	public static final int EMPTY = 0;
	public static final int BLOCK = 1;
	public static final int WATER = 2;

	private int content;

	public Node(int content) {
		this.content = content;
	}

	public boolean isEmpty(){
		return !containsWater() && !containsBlock();
	}

	private boolean containsBlock() {
		return content == BLOCK;

	}

	private boolean containsWater() {
		return content == WATER;
	}

}
