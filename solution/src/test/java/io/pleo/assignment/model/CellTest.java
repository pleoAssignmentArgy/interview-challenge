package io.pleo.assignment.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

	private Cell subject;

	@Test
	public void shouldNotReportEmpty_ifNodeContainsWater() {
		subject = new Cell(new Coordinates(0, 0), Cell.WATER);
		assertFalse(subject.isEmpty());
	}

	@Test
	public void shouldNotReportEmpty_ifNodeContainsBlock() {
		subject = new Cell(new Coordinates(0, 0), Cell.BLOCK);
		assertFalse(subject.isEmpty());
	}
}