package io.pleo.assignment.util;

import io.pleo.assignment.model.Node;

import static io.pleo.assignment.model.Node.BLOCK;
import static io.pleo.assignment.model.Node.WATER;

public class FixtureGenerator {

	public static Node block() {
		return new Node(BLOCK);
	}

	public static Node water() {
		return new Node(WATER);
	}

}
