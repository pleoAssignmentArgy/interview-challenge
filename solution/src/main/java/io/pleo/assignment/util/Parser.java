package io.pleo.assignment.util;

import io.pleo.assignment.model.Structure;

import static java.lang.Integer.parseInt;

public class Parser {

	private Parser() { //no instances allowed
	}

	public static Structure parse(String[] args) {
		if (args == null || args.length == 0) {
			throw new IllegalArgumentException("Bad Input");
		}
		String vector = args[0];
		if (surroundedByBrackets(vector)) {
			int[] intArray = inputToIntArray(vector.substring(1, vector.length() - 1).split(","));
			return new Structure(intArray);
		} else {
			throw new IllegalArgumentException("Bad Input");
		}
	}

	private static boolean surroundedByBrackets(String arg) {
		if (arg.isEmpty()) {
			throw new IllegalArgumentException("Bad input");
		}
		return arg.charAt(0) == '[' && arg.charAt(arg.length() - 1) == ']';
	}

	public static int[] inputToIntArray(String[] args) {
		int[] res = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			res[i] = parseInt(args[i]);
		}
		return res;
	}
}
