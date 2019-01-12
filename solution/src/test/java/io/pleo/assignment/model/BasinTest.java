package io.pleo.assignment.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class BasinTest {

	private Basin subject;

	@Test
	public void shouldDetectLocalHighs_when3NodesInBasin() {
		List<Node> input = asList(node(2), node(1), node(2));
		subject = new Basin(input);

		subject.filterLocalHighs();

		assertTrue(input.get(0).localHigh());
		assertFalse(input.get(1).localHigh());
		assertTrue(input.get(2).localHigh());
	}

	@Test()
	public void shouldNotDetectLocalHighs_when3NodesInBasinAndNoHighs() {
		List<Node> input = asList(node(1), node(2), node(3));
		subject = new Basin(input);
		subject.filterLocalHighs();

		assertFalse(input.get(0).localHigh());
		assertFalse(input.get(1).localHigh());
		assertFalse(input.get(2).localHigh());
	}

	@Test()
	public void shouldDetectLocalHighs_whenMoreThan3NodesInBasin_regular() {
		List<Node> input = asList( node(1), node(2), node(5), node(1));
		subject = new Basin(input);
		subject.filterLocalHighs();

		assertFalse(input.get(0).localHigh());
		assertFalse(input.get(1).localHigh());
		assertTrue(input.get(2).localHigh());
		assertFalse(input.get(3).localHigh());
	}

	@Test()
	public void shouldDetectLocalHighs_whenMoreThan3NodesInBasin_rightnode() {
		List<Node> input = asList( node(2), node(5), node(1), node(3));
		subject = new Basin(input);
		subject.filterLocalHighs();

		assertFalse(input.get(0).localHigh());
		assertTrue(input.get(1).localHigh());
		assertFalse(input.get(2).localHigh());
		assertTrue(input.get(3).localHigh());
	}

	@Test()
	public void shouldDetectLocalHighs_whenMoreThan3NodesInBasin_rightnode2() {
		List<Node> input = asList(
				node(2),
				node(5),
				node(1),
				node(3),
				node(1),
				node(1),
				node(2),
				node(7),
				node(7),
				node(6));
		subject = new Basin(input);
		subject.filterLocalHighs();

		assertFalse(input.get(0).localHigh());
		assertTrue(input.get(1).localHigh());
		assertFalse(input.get(2).localHigh());
		assertTrue(input.get(3).localHigh());
		assertFalse(input.get(4).localHigh());
		assertFalse(input.get(5).localHigh());
		assertFalse(input.get(6).localHigh());
		assertTrue(input.get(7).localHigh());
		assertFalse(input.get(8).localHigh());
		assertFalse(input.get(9).localHigh());


	}


	@Test()
	public void shouldDetectLocalHighs_whenMoreThan3NodesInBasin_RightestNodeCase() {
		List<Node> input = asList(node(1), node(2), node(7), node(7));
		subject = new Basin(input);
		subject.filterLocalHighs();

		assertFalse(input.get(0).localHigh());
		assertFalse(input.get(1).localHigh());
		assertTrue(input.get(2).localHigh());
		assertFalse(input.get(3).localHigh());
	}


	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenLessThan3NodesInBasin() {
		subject = new Basin(Arrays.asList(node(1), node(2)));
		subject.filterLocalHighs();
	}

	private Node node(int i) {
		return new Node(i);
	}

}