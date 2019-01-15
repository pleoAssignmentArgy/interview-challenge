package io.pleo.assignment;

import io.pleo.assignment.exceptions.ParseException;
import io.pleo.assignment.model.Structure;

import static io.pleo.assignment.util.Parser.parse;
import static java.lang.System.exit;

public class Main {

	public static void main(String[] args) {
		if (args != null) {
			try {
				Structure structure = null;
				structure = parse(args);
				System.out.println("Before Rain:");
				structure.print();
				System.out.println("After Rain:");
				structure.rain();
				structure.print();
				System.out.println("Units of water after rain : " + structure.countWaterUnits());

			} catch (ParseException e) {
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
