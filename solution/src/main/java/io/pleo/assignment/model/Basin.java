package io.pleo.assignment.model;

import java.util.List;

import static io.pleo.assignment.model.LocalHighsFilter.filterLocalHighs;

public class Basin {

	private List<Node> nodes;

	public Basin(List<Node> nodes) {
		if (nodes.size() < 3) {
			throw new IllegalArgumentException("Cannot form basin with less than 3 nodes");
		}
		this.nodes = nodes;
	}

	public int calculateWater() {
		filterLocalHighs(nodes);
		return 1;
	}

}
