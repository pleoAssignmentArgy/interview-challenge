package io.pleo.assignment.model;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TerrainTest {

	private Terrain subject;

	@Test
	public void emptyTerrain_GeneratesCorrectSizeTable() {

		int numOfRows = 2;
		int numOfColumns = 3;

		Node[][] nodes = Terrain.emptyTerrain(numOfColumns, numOfRows);

		assertThat(nodes.length, Is.is(numOfColumns));
		assertThat(nodes[0].length, Is.is(numOfRows));
	}

	@Test
	public void emptyTerrain_GeneratesTableWithEmptyNodes() {

		int numOfRows = 2;
		int numOfColumns = 3;

		Node[][] nodes = Terrain.emptyTerrain(numOfColumns, numOfRows);

		for (int i = 0; i < numOfColumns; i++) {
			for (int j = 0; j < numOfRows; j++) {
				assertTrue(nodes[i][j].isEmpty());
			}
		}
	}

	@Test
	public void constructorGeneratesTableWith_NumOfColumnMaxNode_NumOfRowNumOfInputElements() {
		int[] input = {1, 5}; //

		subject = new Terrain(input);

		Node[][] nodes = subject.nodes();

		assertThat(nodes.length, Is.is(2));
		assertThat(nodes[0].length, Is.is(5));
	}

	@Test
	public void constructorGeneratesTableWith_BlocksAppropriately() {
		int[] input = {1, 5};

		subject = new Terrain(input);

		Node[][] nodes = subject.nodes();

		assertTrue(nodes[0][0].isBlock());
		assertTrue(nodes[0][1].isEmpty());
		assertTrue(nodes[0][2].isEmpty());
		assertTrue(nodes[0][3].isEmpty());
		assertTrue(nodes[0][4].isEmpty());

		assertTrue(nodes[1][0].isBlock());
		assertTrue(nodes[1][1].isBlock());
		assertTrue(nodes[1][2].isBlock());
		assertTrue(nodes[1][3].isBlock());
		assertTrue(nodes[1][4].isBlock());
	}

//	@Test
//	public void rainShouldCoverAllCellsWithWater_IfNotBlock() {
//		int[] input = {1, 5};
//		subject = new Terrain(input);
//		subject.rain();
//
//		Node[][] nodes = subject.nodes();
//
//		assertTrue(nodes[0][0].isBlock());
//		assertTrue(nodes[0][1].isWater());
//		assertTrue(nodes[0][2].isWater());
//		assertTrue(nodes[0][3].isWater());
//		assertTrue(nodes[0][4].isWater());
//
//		assertTrue(nodes[1][0].isBlock());
//		assertTrue(nodes[1][1].isBlock());
//		assertTrue(nodes[1][2].isBlock());
//		assertTrue(nodes[1][3].isBlock());
//		assertTrue(nodes[1][4].isBlock());
//	}
}