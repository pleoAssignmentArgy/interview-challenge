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

		Cell[][] cells = Terrain.emptyTerrain(numOfColumns, numOfRows);

		assertThat(cells.length, Is.is(numOfColumns));
		assertThat(cells[0].length, Is.is(numOfRows));
	}

	@Test
	public void emptyTerrain_GeneratesTableWithEmptyNodes() {

		int numOfRows = 2;
		int numOfColumns = 3;

		Cell[][] cells = Terrain.emptyTerrain(numOfColumns, numOfRows);

		for (int i = 0; i < numOfColumns; i++) {
			for (int j = 0; j < numOfRows; j++) {
				assertTrue(cells[i][j].isEmpty());
			}
		}
	}

	@Test
	public void constructorGeneratesTableWith_NumOfColumnMaxNode_NumOfRowNumOfInputElements() {
		int[] input = {1, 5}; //

		subject = new Terrain(input);

		Cell[][] cells = subject.nodes();

		assertThat(cells.length, Is.is(2));
		assertThat(cells[0].length, Is.is(5));
	}

	@Test
	public void constructorGeneratesTableWith_BlocksAppropriately() {
		int[] input = {1, 5};

		subject = new Terrain(input);

		Cell[][] cells = subject.nodes();

		assertTrue(cells[0][0].isBlock());
		assertTrue(cells[0][1].isEmpty());
		assertTrue(cells[0][2].isEmpty());
		assertTrue(cells[0][3].isEmpty());
		assertTrue(cells[0][4].isEmpty());

		assertTrue(cells[1][0].isBlock());
		assertTrue(cells[1][1].isBlock());
		assertTrue(cells[1][2].isBlock());
		assertTrue(cells[1][3].isBlock());
		assertTrue(cells[1][4].isBlock());
	}

	@Test
	public void rainShouldCoverAllCellsWithWater_IfNotBlock() {
		int[] input = {1, 5};
		subject = new Terrain(input);
		subject.rain();

		Cell[][] cells = subject.nodes();

		assertTrue(cells[0][0].isBlock());
		assertTrue(cells[0][1].isWater());
		assertTrue(cells[0][2].isWater());
		assertTrue(cells[0][3].isWater());
		assertTrue(cells[0][4].isWater());

		assertTrue(cells[1][0].isBlock());
		assertTrue(cells[1][1].isBlock());
		assertTrue(cells[1][2].isBlock());
		assertTrue(cells[1][3].isBlock());
		assertTrue(cells[1][4].isBlock());
	}
}