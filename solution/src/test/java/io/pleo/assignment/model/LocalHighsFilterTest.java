package io.pleo.assignment.model;

import org.junit.Test;

import java.util.List;

import static io.pleo.assignment.util.FixtureGenerator.node;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocalHighsFilterTest {

	private LocalHighsFilter subject = new LocalHighsFilter();

	@Test
	public void shouldDetectLocalHighs_when3NodesInBasin() {
		List<Node> input = asList(
				node(2,0),
				node(1,1),
				node(2,2));
		subject = new LocalHighsFilter();

		subject.filterLocalHighs(input);

		assertTrue(input.get(0).localHigh());
		assertFalse(input.get(1).localHigh());
		assertTrue(input.get(2).localHigh());
	}

	@Test()
	public void shouldNotDetectLocalHighs_when3NodesInBasinAndNoHighs() {
		List<Node> input = asList(
				node(1,0),
				node(2,1),
				node(3,2)
		);
		subject.filterLocalHighs(input);

		assertFalse(input.get(0).localHigh());
		assertFalse(input.get(1).localHigh());
		assertFalse(input.get(2).localHigh());
	}

	@Test()
	public void shouldDetectLocalHighs_whenMoreThan3NodesInBasin_regular() {
		List<Node> input = asList(
				node(1, 0),
				node(2, 1),
				node(5, 2),
				node(1,3));
		subject.filterLocalHighs(input);

		assertFalse(input.get(0).localHigh());
		assertFalse(input.get(1).localHigh());
		assertTrue(input.get(2).localHigh());
		assertFalse(input.get(3).localHigh());
	}

	@Test()
	public void shouldDetectLocalHighs_whenMoreThan3NodesInBasin_rightnode() {
		List<Node> input = asList(
				node(2, 0),
				node(5, 1),
				node(1,2),
				node(3,3));
		subject.filterLocalHighs(input);

		assertFalse(input.get(0).localHigh());
		assertTrue(input.get(1).localHigh());
		assertFalse(input.get(2).localHigh());
		assertTrue(input.get(3).localHigh());
	}

	@Test()
	public void shouldDetectLocalHighs_whenMoreThan3NodesInBasin_rightnode2() {
		List<Node> input = asList(
				node(2, 0),
				node(5,1),
				node(1,2),
				node(3,3),
				node(1,4),
				node(1,5),
				node(2,6),
				node(7,7),
				node(7,8),
				node(6,9));
		subject.filterLocalHighs(input);

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
		List<Node> input = asList(
				node(1,0),
				node(2,1),
				node(7,2),
				node(7,3)
		);
		subject.filterLocalHighs(input);

		assertFalse(input.get(0).localHigh());
		assertFalse(input.get(1).localHigh());
		assertTrue(input.get(2).localHigh());
		assertFalse(input.get(3).localHigh());
	}





}