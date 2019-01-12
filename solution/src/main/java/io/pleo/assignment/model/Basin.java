package io.pleo.assignment.model;

import java.util.List;

//import static io.pleo.assignment.model.BasinEdgeDetector.detectEdges;
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
//		detectEdges(nodes);
		//update all nodes with edges height
		//loop through all basin nodes add BasinHeight-node.value
//		findTheSurface(modes)

		//loop through the basin from left e

		return nodes.stream().map(node -> {
			int result = node.surface() - node.value();
			if (result < 0) {
				return 0;
			} else return result;
		}).reduce((integer, integer2) -> integer + integer2).get();
	}

}
