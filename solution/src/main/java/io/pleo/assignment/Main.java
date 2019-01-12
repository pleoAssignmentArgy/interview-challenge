package io.pleo.assignment;

import static io.pleo.assignment.util.Parser.parse;
import static java.lang.System.exit;

public class Main {

	public static void main(String[] args) {
		if (args != null) {
			parse(args);
		} else {
			printErrorAndExit();
		}
	}


	private static void printErrorAndExit() {
		System.out.println("Bad input");
		exit(-1);
	}
}
