package io.pleo.assignment.util;

import io.pleo.assignment.model.Structure;
import org.junit.Test;

import static io.pleo.assignment.util.Parser.parse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

public class ParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandle_NullArrayStringInput() {
		parse(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandle_EmptyArrayStringInput() {
		parse(new String[]{});
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandle_BadFormattedInput_emptyStrings() {
		parse(new String[]{""});
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandle_BadFormattedInput_noCommas() {
		parse(new String[]{"[1 2 3]"});
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandle_BadFormattedInput_NoNumbers() {
		parse(new String[]{"[1, chair, 3]"});
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandle_BadFormattedInput_noBrackets() {
		parse(new String[]{"1,2,3"});
	}

	@Test
	public void shouldHandle_properUserInput() {
		Structure parse = parse(new String[]{"[1,2,3]"});
		assertNotNull(parse);
	}

	@Test
	public void shouldConvertStringArrayInputToIntArray_properly() {
		int[] res = Parser.inputToIntArray(new String[]{"1", "2", "3"});

		assertThat(res[0], is(1));
		assertThat(res[1], is(2));
		assertThat(res[2], is(3));
	}
}