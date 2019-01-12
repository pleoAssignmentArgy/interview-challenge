//package io.pleo.assignment.model;
//
//import org.junit.Test;
//
//import java.util.List;
//
//import static io.pleo.assignment.util.FixtureGenerator.localHighNode;
//import static io.pleo.assignment.util.FixtureGenerator.node;
//import static java.util.Arrays.asList;
//import static org.junit.Assert.*;
//
//public class BasinEdgeDetectorTest {
//
//	@Test
//	public void shouldDetectEdges_when2LocalHighs() {
//
//		List<Node> input = asList(
//				localHighNode(2),
//				node(1),
//				localHighNode(2));
//
//		BasinEdgeDetector.detectEdges(input);
//
//		assertFalse(input.get(0).underwater());
//		assertTrue(input.get(1).underwater());
//		assertFalse(input.get(2).underwater());
//	}
//
//
//	@Test
//	public void shouldDetectEdges_whenMultipleLocalHighs() {
//
//		List<Node> input = asList(
//				localHighNode(3),
//				node(1),
//				localHighNode(2),
//				node(1),
//				localHighNode(3));
//
//		BasinEdgeDetector.detectEdges(input);
//
//		assertFalse(input.get(0).underwater());
//		assertTrue(input.get(1).underwater());
//		assertTrue(input.get(2).underwater());
//		assertTrue(input.get(3).underwater());
//		assertFalse(input.get(4).underwater());
//	}
//
//	@Test
//	public void shouldDetectEdges_whenMultipleLocalHighs_TwoConsecutiveLocalHighsEqual() {
//
//		List<Node> input = asList(
//				localHighNode(3),
//				node(1),
//				localHighNode(2),
//				node(1),
//				localHighNode(2));
//
//		BasinEdgeDetector.detectEdges(input);
//
//		assertFalse(input.get(0).underwater());
//		assertTrue(input.get(1).underwater());
//		assertFalse(input.get(2).underwater());
//		assertTrue(input.get(3).underwater());
//		assertFalse(input.get(4).underwater());
//	}
//
//	@Test
//	public void shouldDetectEdges_whenMultipleLocalHighs_TwoMultipleConsecutiveLocalHighsEqual() {
//
//		List<Node> input = asList(
//				localHighNode(2),
//				node(1),
//				localHighNode(2),
//				node(1),
//				localHighNode(2));
//
//		BasinEdgeDetector.detectEdges(input);
//
//		assertFalse(input.get(0).underwater());
//		assertTrue(input.get(1).underwater());
//		assertFalse(input.get(2).underwater());
//		assertTrue(input.get(3).underwater());
//		assertFalse(input.get(4).underwater());
//	}
//
//	@Test
//	public void shouldDetectEdges_whenMultipleLocalHighs_TwoMultipleConsecutiveLocalHighsEqual2() {
//		List<Node> input = asList(
//				localHighNode(2),
//				node(1),
//				localHighNode(2),
//				node(1),
//				localHighNode(3),
//				node(1),
//				localHighNode(2));
//
//		BasinEdgeDetector.detectEdges(input);
//
//		assertFalse(input.get(0).underwater());
//		assertTrue(input.get(1).underwater());
//		assertFalse(input.get(2).underwater());
//		assertTrue(input.get(3).underwater());
//		assertFalse(input.get(4).underwater());
//		assertTrue(input.get(5).underwater());
//		assertFalse(input.get(6).underwater());
//	}
//
//	@Test
//	public void shouldDetectEdges_whenMultipleLocalHighs_TwoMultipleConsecutiveLocalHighsEqual3() {
//
//		List<Node> input = asList(
//				localHighNode(3),
//				node(1),
//				localHighNode(2),
//				node(1),
//				localHighNode(3),
//				node(1),
//				localHighNode(2));
//
//		BasinEdgeDetector.detectEdges(input);
//
//		assertFalse(input.get(0).underwater());
//		assertTrue(input.get(1).underwater());
//		assertFalse(input.get(2).underwater());
//		assertTrue(input.get(3).underwater());
//		assertFalse(input.get(4).underwater());
//		assertTrue(input.get(5).underwater());
//		assertFalse(input.get(6).underwater());
//	}
//
//	@Test
//	public void shouldDetectEdges_whenMultipleLocalHighs_TwoMultipleConsecutiveLocalHighsEqual4() {
//
//		List<Node> input = asList(
//				localHighNode(3),
//				node(1),
//				localHighNode(4),
//				node(1),
//				localHighNode(4),
//				node(1),
//				localHighNode(2));
//
//		BasinEdgeDetector.detectEdges(input);
//
//		assertFalse(input.get(0).underwater());
//		assertTrue(input.get(1).underwater());
//		assertFalse(input.get(2).underwater());
//		assertTrue(input.get(3).underwater());
//		assertFalse(input.get(4).underwater());
//		assertTrue(input.get(5).underwater());
//		assertFalse(input.get(6).underwater());
//	}
//
//	@Test
//	public void shouldDetectEdges_whenMultipleLocalHighs_TwoMultipleConsecutiveLocalHighsEqual5() {
//
//		List<Node> input = asList(
//				localHighNode(5),
//				node(1),
//				localHighNode(3),
//				node(1),
//				localHighNode(2),
//				node(1),
//				localHighNode(4));
//
//		BasinEdgeDetector.detectEdges(input);
//
//		assertFalse(input.get(0).underwater());
//		assertTrue(input.get(1).underwater());
//		assertFalse(input.get(2).underwater());
//		assertTrue(input.get(3).underwater());
//		assertFalse(input.get(4).underwater());
//		assertTrue(input.get(5).underwater());
//		assertFalse(input.get(6).underwater());
//	}
//
//}