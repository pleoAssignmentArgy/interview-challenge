package io.pleo.assignment.util;

import io.pleo.assignment.model.Node;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	private Parser(){ //no instances allowed
	}

	public static List<Node> parse(String[] args) {
		if(args == null){
			throw new IllegalArgumentException("Bad Input");
		}
		String vector = args[0];
		if (properlyFormatted(vector)){
			return createNodes(vector.substring(1, vector.length()-1).split(","));
		} else {
			throw new IllegalArgumentException("Bad Input");
		}
	}

	private static boolean properlyFormatted(String arg) {
		return arg.charAt(0) == '[' && arg.charAt(arg.length()-1) == ']';
	}

	private static List<Node> createNodes(String[] args) {
		ArrayList res = new ArrayList();
		for (String a : args) {
			res.add(new Node(Integer.parseInt(a)));
		}
		return res;
	}
}
