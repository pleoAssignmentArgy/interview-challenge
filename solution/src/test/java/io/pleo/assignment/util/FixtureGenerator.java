package io.pleo.assignment.util;

import io.pleo.assignment.model.Node;

public class FixtureGenerator {

	public static Node node(int i, int locationInBasin) {
		return new Node(i, locationInBasin);
	}

	public static Node localHighNode(int i ) {
		return new Node(i, true);
	}

	public static Node node(int value, int surface, int locationInBasin){
		return new Node(value, locationInBasin, surface);
	}

}
