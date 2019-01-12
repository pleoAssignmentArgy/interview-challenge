package io.pleo.assignment;

import io.pleo.assignment.model.Basin;
import io.pleo.assignment.model.Node;

import java.util.List;

import static io.pleo.assignment.util.Parser.parse;
import static java.lang.System.exit;

public class Main {

	public static void main(String[] args) {
		if (args != null) {
			List<Node> nodes = parse(args);

			Basin basin = new Basin(nodes);
			basin.calculateWater();

		} else {
			printErrorAndExit();
		}
	}



	private static void printErrorAndExit() {
		System.out.println("Bad input");
		exit(-1);
	}
}
