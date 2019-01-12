package io.pleo.assignment.model;

import org.junit.Test;

import java.util.List;

import static io.pleo.assignment.util.FixtureGenerator.node;
import static java.util.Arrays.asList;

public class BasinTest {

	private Basin subject;

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenLessThan3NodesInBasin() {
		List<Node> input = asList(node(1), node(2));
		subject = new Basin(input);
	}


}