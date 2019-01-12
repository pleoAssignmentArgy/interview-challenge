package io.pleo.assignment.model;

public class Node {

	private int value;
	private boolean localHigh;

	public Node(int value) {
		this.value = value;
		this.localHigh = false;
	}

	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				", localHigh=" + localHigh +
				'}';
	}

	public int value() {
		return value;
	}

	public void localHigh(boolean localHigh) {
		this.localHigh = localHigh;
	}

	public boolean localHigh() {
		return localHigh;
	}
}
