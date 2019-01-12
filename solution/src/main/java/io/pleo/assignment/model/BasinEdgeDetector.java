//package io.pleo.assignment.model;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class BasinEdgeDetector {
//
//
//	public static void detectEdges(List<Node> input) {
//		List<Node> localHighs = new ArrayList<>(input.stream()
//				.filter(Node::localHigh).collect(Collectors.toList()));
//
//		if (localHighs.size() == 2) {
//			localHighs.get(0).underwater(false);
//			localHighs.get(1).underwater(false);
//		} else {
//			for (int i = 2; i < localHighs.size(); i++) {
//				Node left = localHighs.get(i - 2);
//				Node middle = localHighs.get(i - 1);
//				Node right = localHighs.get(i);
//				left.underwater(false);
//				right.underwater(false);
//				middle.underwater(false);
//				if (isMiddleLocalHighUnderwater(left, middle, right)) {
//					middle.underwater(true);
//				}
//			}
//		}
//	}
//
//
//	public static boolean isMiddleLocalHighUnderwater(Node left, Node middle, Node right) {
//		return left.value() > middle.value() && middle.value() < right.value();
//	}
//
//
//}
