package io.pleo.assignment.model;

public class Node {

	private int value;
	private boolean isLocalHigh;
	private int surface;

	public Node(int value) {
		this.value = value;
		this.isLocalHigh = false;
	}
	public Node(int value, int surface) {
		this.value = value;
		this.surface = surface;
	}

	public Node(int value, boolean localHigh) {
		this.value = value;
		this.isLocalHigh = localHigh;
	}


	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				", isLocalHigh=" + isLocalHigh +
				'}';
	}

	public int value() {
		return value;
	}

	public void localHigh(boolean localHigh) {
		this.isLocalHigh = localHigh;
	}

	public boolean localHigh() {
		return isLocalHigh;
	}

	public int surface() {
		return surface;
	}

	public void surface(int surface) {
		this.surface = surface;
	}
}
