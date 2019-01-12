package io.pleo.assignment.util;

import io.pleo.assignment.model.Node;
import io.pleo.assignment.model.Terrain;
import org.junit.Test;

import static io.pleo.assignment.util.Parser.parse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandle_EmptyString() {
		parse(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandle_BadFormatedInput_noCommas() {
		parse(new String[]{"[1 2 3]"});
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandle_BadFormatedInput_noBrackets() {
		parse(new String[]{"1,2,3"});
	}

	@Test
	public void shouldInputToInt_properly() {
		int[] res = Parser.inputToIntArray(new String[]{"1","2","3"});

		assertThat(res[0], is(1));
		assertThat(res[1], is(2));
		assertThat(res[2], is(3));

	}
}