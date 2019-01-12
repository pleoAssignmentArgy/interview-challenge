package io.pleo.assignment.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

	private Node subject;

	@Test
	public void shouldNotReportEmpty_ifNodeContainsWater(){
		subject = new Node(Node.WATER);
		assertFalse(subject.isEmpty());
	}

	@Test
	public void shouldNotReportEmpty_ifNodeContainsBlock(){
		subject = new Node(Node.BLOCK);
		assertFalse(subject.isEmpty());
	}
}