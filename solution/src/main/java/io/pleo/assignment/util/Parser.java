package io.pleo.assignment.util;

import io.pleo.assignment.exceptions.ParseException;
import io.pleo.assignment.model.Structure;

import static java.lang.Integer.parseInt;

public class Parser {

	private Parser() { //no instances allowed
	}

	public static Structure parse(String[] args) throws ParseException {
		if (args == null || args.length == 0) {
			throw new ParseException("Bad Input");
		}
		String vector = args[0];
		if (surroundedByBrackets(vector)) {
			int[] intArray = inputToIntArray(vector.substring(1, vector.length() - 1).split(","));
			return new Structure(intArray);
		} else {
			throw new ParseException("Bad Input");
		}
	}

	private static boolean surroundedByBrackets(String arg) throws ParseException {
		if (arg.isEmpty()) {
			throw new ParseException("Bad Input");
		}
		return arg.charAt(0) == '[' && arg.charAt(arg.length() - 1) == ']';
	}

	public static int[] inputToIntArray(String[] args) throws ParseException {
		int[] res = new int[args.length];
		try {

			for (int i = 0; i < args.length; i++) {
				res[i] = parseInt(args[i]);
			}
		} catch (NumberFormatException e) {
			throw new ParseException(e.getMessage());
		}
		return res;
	}
}
