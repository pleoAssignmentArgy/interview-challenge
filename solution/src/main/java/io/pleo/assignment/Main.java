package io.pleo.assignment;

import io.pleo.assignment.model.Structure;
import io.pleo.assignment.util.Parser;

import static io.pleo.assignment.util.Parser.parse;
import static java.lang.System.exit;

public class Main {

	public static void main(String[] args) {
		if (args != null) {
			try {
				System.out.println("Before Rain:");
				Structure structure = parse(args);
				structure.print();
				System.out.println("After Rain:");
				structure.rain();
				structure.print();
				System.out.println("Units of water after rain : " + structure.countWaterUnits());

			} catch (IllegalArgumentException e) {
				printErrorAndExit();
			}
		} else {
			printErrorAndExit();
		}
	}

	private static void printErrorAndExit() {
		System.out.println("Bad input");
		exit(-1);
	}
}
