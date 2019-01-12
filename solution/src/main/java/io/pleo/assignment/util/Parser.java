package io.pleo.assignment.util;

import io.pleo.assignment.model.Terrain;

import static java.lang.Integer.parseInt;

public class Parser {

	private Parser() { //no instances allowed
	}

	public static Terrain parse(String[] args) {
		if (args == null) {
			throw new IllegalArgumentException("Bad Input");
		}
		String vector = args[0];
		if (properlyFormatted(vector)) {
			int[] intArray = inputToIntArray(vector.substring(1, vector.length() - 1).split(","));
			return new Terrain(intArray);
		} else {
			throw new IllegalArgumentException("Bad Input");
		}
	}

	private static boolean properlyFormatted(String arg) {
		return arg.charAt(0) == '[' && arg.charAt(arg.length() - 1) == ']';
	}

	static int[] inputToIntArray(String[] args) {
		int[] res = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			res[i] = parseInt(args[i]);
		}
		return res;
	}
}
