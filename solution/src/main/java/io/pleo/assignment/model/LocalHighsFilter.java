package io.pleo.assignment.model;

import java.util.List;

public class LocalHighsFilter {

	static void filterLocalHighs(List<Node> nodes) {
		if (nodes.size() == 3) {
			localHighsForThreeNodes(nodes);
		} else {
			for (int i = 2; i < nodes.size(); i++) {
				localHighs(nodes, i);
			}
		}
	}

	private static  void localHighs(List<Node> nodes, int i) {
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

	private static  void localHighsForThreeNodes(List <Node> nodes) {
		if (nodes.get(0).value() > nodes.get(1).value() && nodes.get(2).value() > nodes.get(1).value()) {
			nodes.get(0).localHigh(true);
			nodes.get(2).localHigh(true);
		}
	}

	private static boolean highestInMiddle(int left, int middle, int right) {
		return left < middle && right <= middle;
	}
}
