package io.pleo.assignment.model;

import java.util.List;

public class Basin {

	private List<Node> nodes;

	public Basin(List<Node> nodes) {
		if (nodes.size() < 3) {
			throw new IllegalArgumentException("Cannot form basin with less than 3 nodes");
		}
		this.nodes = nodes;
	}

	public int calculateWater() {
		for (Node node : nodes) {
			System.out.println("Node : " + node);
		}
		return 1;
	}

	void filterLocalHighs() {
		if (nodes.size() == 3) {
			localHighsForThreeNodes();
		} else {
			for (int i = 2; i < nodes.size(); i++) {
				localHighs(i);
			}
		}
	}

	private void localHighs(int i) {
		Node left = nodes.get(i - 2);
		Node middle = nodes.get(i - 1);
		Node right = nodes.get(i);
		if (highestInMiddle(left.value(), middle.value(), right.value())) {
			middle.localHigh(true);
		}
		if (right.value() > middle.value() && i == nodes.size() - 1) {
			right.localHigh(true);
		}
	}

	private void localHighsForThreeNodes() {
		if (nodes.get(0).value() > nodes.get(1).value() && nodes.get(2).value() > nodes.get(1).value()) {
			nodes.get(0).localHigh(true);
			nodes.get(2).localHigh(true);
		}
	}

	private boolean highestInMiddle(int left, int middle, int right) {
		return left < middle && right <= middle;
	}
}
