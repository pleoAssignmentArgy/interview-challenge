package io.pleo.assignment;

import io.pleo.assignment.model.Node;
import io.pleo.assignment.util.Parser;

import java.util.ArrayList;
import java.util.List;

import static io.pleo.assignment.util.Parser.parse;
import static java.lang.System.exit;

public class Main {

	public static void main(String[] args) {
		if (args != null) {
			List<Node> nodes = parse(args);
			for (Node node : nodes) {
				System.out.println("Node : " + node);
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
