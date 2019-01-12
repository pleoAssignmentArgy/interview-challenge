package io.pleo.assignment.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TerrainTest {

	private Terrain subject;

	@Test
	public void emptyTerrain_GeneratesCorrectSizeTable() {

		int numOfRows = 2;
		int numOfColumns = 3;

		Cell[][] cells = Terrain.emptyTerrain(numOfColumns, numOfRows);

		assertThat(cells.length, is(numOfColumns));
		assertThat(cells[0].length, is(numOfRows));
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

		Cell[][] cells = subject.cells();

		assertThat(cells.length, is(2));
		assertThat(cells[0].length, is(5));
	}

	@Test
	public void constructorGeneratesTableWith_BlocksAppropriately() {
		int[] input = {1, 5};

		subject = new Terrain(input);

		Cell[][] cells = subject.cells();

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
	public void shouldFindShortestNeighbor_toLeft() {
		int[] input = {1, 5, 4};
		subject = new Terrain(input);

		Cell cell = subject.cells()[1][4];

		Cell shortestNeighbor = subject.findShortestNeighborForCell(cell);

		assertThat(shortestNeighbor.coordinates().column(), is(0));
		assertThat(shortestNeighbor.coordinates().row(), is(1));
	}

	@Test
	public void shouldFindShortestNeighbor_toRight() {
		int[] input = {5, 4, 1};
		subject = new Terrain(input);

		Cell cell = subject.cells()[1][4];

		Cell shortestNeighbor = subject.findShortestNeighborForCell(cell);

		assertThat(shortestNeighbor.coordinates().column(), is(2));
		assertThat(shortestNeighbor.coordinates().row(), is(1));
	}

	@Test
	public void shouldRain_fillsSingleBasinWithWater() {
		int[] input = {3, 1, 3};
		subject = new Terrain(input);
		subject.rain();

		assertThat(subject.cells()[1][1].isWater(), is(true));
		assertThat(subject.cells()[1][2].isWater(), is(true));
	}

	@Test
	public void shouldRain_fillsMultipleBasinsWithWater() {
		int[] input = {4, 1, 2, 1, 5};
		subject = new Terrain(input);
		subject.rain();


		assertThat(subject.cells()[1][1].isWater(), is(true));
		assertThat(subject.cells()[1][2].isWater(), is(true));
		assertThat(subject.cells()[1][3].isWater(), is(true));

		assertThat(subject.cells()[2][2].isWater(), is(true));
		assertThat(subject.cells()[2][3].isWater(), is(true));

		assertThat(subject.cells()[3][1].isWater(), is(true));
		assertThat(subject.cells()[3][2].isWater(), is(true));
		assertThat(subject.cells()[3][3].isWater(), is(true));


		//and the rest are not water
		assertThat(subject.cells()[0][0].isWater(), is(false));
		assertThat(subject.cells()[0][1].isWater(), is(false));
		assertThat(subject.cells()[0][2].isWater(), is(false));
		assertThat(subject.cells()[0][3].isWater(), is(false));
		assertThat(subject.cells()[0][4].isWater(), is(false));

		assertThat(subject.cells()[1][0].isWater(), is(false));
		assertThat(subject.cells()[1][4].isWater(), is(false));

		assertThat(subject.cells()[2][0].isWater(), is(false));
		assertThat(subject.cells()[2][1].isWater(), is(false));
		assertThat(subject.cells()[2][4].isWater(), is(false));

		assertThat(subject.cells()[3][0].isWater(), is(false));
		assertThat(subject.cells()[3][4].isWater(), is(false));

		assertThat(subject.cells()[4][0].isWater(), is(false));
		assertThat(subject.cells()[4][1].isWater(), is(false));
		assertThat(subject.cells()[4][2].isWater(), is(false));
		assertThat(subject.cells()[4][3].isWater(), is(false));
		assertThat(subject.cells()[4][4].isWater(), is(false));

	}

	@Test
	public void counts_waterUnits_plateuau() {
		int[] input = {1, 1, 1, 1, 1, 1};

		subject = new Terrain(input);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(0));

	}

	@Test
	public void counts_waterUnits() {
		Cell[][] cells = new Cell[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == j) { //3 water items
					cells[i][j] = new Cell(new Coordinates(i, j), Cell.WATER);
				} else {
					cells[i][j] = new Cell(new Coordinates(i, j), Cell.BLOCK);
				}

			}
		}

		subject = new Terrain(cells);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(3));

	}

}