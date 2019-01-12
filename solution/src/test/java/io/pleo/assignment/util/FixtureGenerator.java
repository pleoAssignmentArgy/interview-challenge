package io.pleo.assignment.util;

import io.pleo.assignment.model.Cell;

import static io.pleo.assignment.model.Cell.BLOCK;
import static io.pleo.assignment.model.Cell.WATER;

public class FixtureGenerator {

	public static Cell block() {
		return new Cell(BLOCK);
	}

	public static Cell water() {
		return new Cell(WATER);
	}

}
