package io.pleo.assignment.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TerrainTest {

	private Terrain subject;

	@Test
	public void emptyTerrain_GeneratesTableWithEmptyNodes() {

		int numOfRows = 3;
		int numOfColumns = 3;

		Node[][] nodes = Terrain.emptyTerrain(numOfColumns, numOfRows);

		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				assertTrue(nodes[i][j].isEmpty());
			}
		}
	}

}