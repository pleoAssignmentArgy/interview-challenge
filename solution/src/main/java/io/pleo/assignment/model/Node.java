package io.pleo.assignment.model;

public class Node {

	private int locationInBasin;
	private int value;
	private boolean isLocalHigh;
	private int surface;

	public Node(int value, int locationInBasin) {
		this.value = value;
		this.isLocalHigh = false;
		this.locationInBasin = locationInBasin;
	}
	public Node(int value, int locationInBasin,  int surface) {
		this.value = value;
		this.surface = surface;
		this.locationInBasin = locationInBasin;
	}

	public Node(int value, boolean localHigh) {
		this.value = value;
		this.isLocalHigh = localHigh;
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

	public int locationInBasin() {
		return locationInBasin;
	}

	public int surface() {
		return surface;
	}

	public void surface(int surface) {
		this.surface = surface;
	}
}
