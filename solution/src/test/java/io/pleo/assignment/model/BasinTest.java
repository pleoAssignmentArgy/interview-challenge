package io.pleo.assignment.model;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

import static io.pleo.assignment.util.FixtureGenerator.node;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasinTest {

	private Basin subject;

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_whenLessThan3NodesInBasin() {
		List<Node> input = asList(
				node(1,0),
				node(2,1));
		subject = new Basin(input);
	}

	@Test
	public void shouldCalculateWaterUnitsForAllNodes() {
		List<Node> input = asList(
				node(2, 2,0),
				node(1, 2, 1),
				node(4, 2,2)
		);
		Basin basin = new Basin(input);

		int waterUnits = basin.calculateWater();

		assertThat(waterUnits, Is.is(1));
	}

	@Test
	public void shouldCalculateWaterUnitsForAllNodes2() {
		List<Node> input = asList(
				node(5, 5, 0),
				node(1, 5,1),
				node(3, 5,1),
				node(1, 5,2),
				node(2, 5,3),
				node(1, 5,4),
				node(7, 5,5),
				node(7, 5,6)
		);
		subject = new Basin(input);

		int waterUnits = subject.calculateWater();

		assertThat(waterUnits, Is.is(17));
	}

}