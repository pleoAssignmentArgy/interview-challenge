package io.pleo.assignment.util;

import io.pleo.assignment.model.Node;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

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

	@Test()
	public void shouldHandle_ProperlyFormatedInput() {
		List<Node> parse = parse(new String[]{"[1,2,3]"});
		assertThat(parse.size(), is(3));
	}

}