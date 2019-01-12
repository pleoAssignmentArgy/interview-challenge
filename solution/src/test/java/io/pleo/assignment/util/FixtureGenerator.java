package io.pleo.assignment.util;

import io.pleo.assignment.model.Node;

public class FixtureGenerator {

	public static Node node(int i) {
		return new Node(i);
	}

	public static Node localHighNode(int i) {
		return new Node(i, true);
	}

	public static Node node(int value, int surface){
		return new Node(value, surface);
	}

}
