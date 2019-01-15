package io.pleo.assignment.util;

import io.pleo.assignment.exceptions.ParseException;
import io.pleo.assignment.model.Structure;
import org.junit.Test;

import static io.pleo.assignment.util.Parser.parse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

public class ParserTest {

	@Test(expected = ParseException.class)
	public void shouldHandle_NullArrayStringInput() throws ParseException {
		parse(null);
	}

	@Test(expected = ParseException.class)
	public void shouldHandle_EmptyArrayStringInput() throws ParseException {
		parse(new String[]{});
	}

	@Test(expected = ParseException.class)
	public void shouldHandle_BadFormattedInput_emptyStrings() throws ParseException {
		parse(new String[]{""});
	}

	@Test(expected = ParseException.class)
	public void shouldHandle_BadFormattedInput_noCommas() throws ParseException {
		parse(new String[]{"[1 2 3]"});
	}

	@Test(expected = ParseException.class)
	public void shouldHandle_BadFormattedInput_NoNumbers() throws ParseException {
		parse(new String[]{"[1, chair, 3]"});
	}

	@Test(expected = ParseException.class)
	public void shouldHandle_BadFormattedInput_noBrackets() throws ParseException {
		parse(new String[]{"1,2,3"});
	}

	@Test
	public void shouldHandle_properUserInput() throws ParseException {
		Structure parse = parse(new String[]{"[1,2,3]"});
		assertNotNull(parse);
	}

	@Test
	public void shouldConvertStringArrayInputToIntArray_properly() throws ParseException {
		int[] res = Parser.inputToIntArray(new String[]{"1", "2", "3"});

		assertThat(res[0], is(1));
		assertThat(res[1], is(2));
		assertThat(res[2], is(3));
	}
}