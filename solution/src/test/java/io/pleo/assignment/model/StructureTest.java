package io.pleo.assignment.model;

import org.junit.Test;

import static io.pleo.assignment.model.Cell.BLOCK;
import static io.pleo.assignment.model.Cell.WATER;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StructureTest {

	private Structure subject;

	@Test
	public void emptyTerrain_GeneratesCorrectSizeTable() {
		int numOfRows = 2;
		int numOfColumns = 3;

		Cell[][] cells = Structure.emptyStructure(numOfColumns, numOfRows);

		assertThat(cells.length, is(numOfColumns));
		assertThat(cells[0].length, is(numOfRows));
	}

	@Test
	public void emptyTerrain_GeneratesTableWithEmptyNodes() {

		int numOfRows = 2;
		int numOfColumns = 3;

		Cell[][] cells = Structure.emptyStructure(numOfColumns, numOfRows);

		for (int i = 0; i < numOfColumns; i++) {
			for (int j = 0; j < numOfRows; j++) {
				assertTrue(cells[i][j].isEmpty());
			}
		}
	}

	@Test
	public void constructor_GeneratesTable_WithCorrectDimensions() {
		int[] input = {1, 5}; //

		subject = new Structure(input);

		Cell[][] cells = subject.cells();

		assertThat(cells.length, is(2));
		assertThat(cells[0].length, is(5));
	}

	@Test
	public void constructor_GeneratesTable_withEmptyCellsAndBlockCells() {
		int[] input = {1, 5};

		subject = new Structure(input);

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
	public void rain_fillBasinWithWater() {
		int[] input = {3, 1, 3};
		subject = new Structure(input);
		subject.rain();

		assertThat(subject.cells()[1][1].isWater(), is(true));
		assertThat(subject.cells()[1][2].isWater(), is(true));
	}


	@Test
	public void rain_doesNotfillBasinWithWater_ifThereIsHole() {
		int[] input = {3, 0, 3};
		subject = new Structure(input);
		subject.rain();

		assertThat(subject.cells()[1][0].isWater(), is(false));
		assertThat(subject.cells()[1][1].isWater(), is(false));
		assertThat(subject.cells()[1][2].isWater(), is(false));
	}

	@Test
	public void rain_fillsMultipleBasinsWithWater_example1() {
		int[] input = {4, 1, 2, 1, 5};
		subject = new Structure(input);
		subject.rain();

		assertThat(subject.cells()[1][1].isWater(), is(true));
		assertThat(subject.cells()[1][2].isWater(), is(true));
		assertThat(subject.cells()[1][3].isWater(), is(true));

		assertThat(subject.cells()[2][2].isWater(), is(true));
		assertThat(subject.cells()[2][3].isWater(), is(true));

		assertThat(subject.cells()[3][1].isWater(), is(true));
		assertThat(subject.cells()[3][2].isWater(), is(true));
		assertThat(subject.cells()[3][3].isWater(), is(true));


//		and the rest are not water
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
	public void rain_fillsMultipleBasinsWithWater_example2() {
		int[] input = {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};
		subject = new Structure(input);
		subject.rain();

		assertThat(subject.cells()[0][0].isWater(), is(false));
		assertThat(subject.cells()[0][1].isWater(), is(false));
		assertThat(subject.cells()[0][2].isWater(), is(false));
		assertThat(subject.cells()[0][3].isWater(), is(false));
		assertThat(subject.cells()[0][4].isWater(), is(false));
		assertThat(subject.cells()[0][5].isWater(), is(false));
		assertThat(subject.cells()[0][6].isWater(), is(false));

		assertThat(subject.cells()[1][0].isWater(), is(false));
		assertThat(subject.cells()[1][1].isWater(), is(false));
		assertThat(subject.cells()[1][2].isWater(), is(false));
		assertThat(subject.cells()[1][3].isWater(), is(false));
		assertThat(subject.cells()[1][4].isWater(), is(false));
		assertThat(subject.cells()[1][5].isWater(), is(false));
		assertThat(subject.cells()[1][6].isWater(), is(false));

		assertThat(subject.cells()[2][0].isWater(), is(false));
		assertThat(subject.cells()[2][1].isWater(), is(true));
		assertThat(subject.cells()[2][2].isWater(), is(true));
		assertThat(subject.cells()[2][3].isWater(), is(true));
		assertThat(subject.cells()[2][4].isWater(), is(true));
		assertThat(subject.cells()[2][5].isWater(), is(false));
		assertThat(subject.cells()[2][6].isWater(), is(false));

		assertThat(subject.cells()[3][0].isWater(), is(false));
		assertThat(subject.cells()[3][1].isWater(), is(false));
		assertThat(subject.cells()[3][2].isWater(), is(false));
		assertThat(subject.cells()[3][3].isWater(), is(true));
		assertThat(subject.cells()[3][4].isWater(), is(true));
		assertThat(subject.cells()[3][5].isWater(), is(false));
		assertThat(subject.cells()[3][6].isWater(), is(false));

		assertThat(subject.cells()[4][0].isWater(), is(false));
		assertThat(subject.cells()[4][1].isWater(), is(true));
		assertThat(subject.cells()[4][2].isWater(), is(true));
		assertThat(subject.cells()[4][3].isWater(), is(true));
		assertThat(subject.cells()[4][4].isWater(), is(true));
		assertThat(subject.cells()[4][5].isWater(), is(false));
		assertThat(subject.cells()[4][6].isWater(), is(false));

		assertThat(subject.cells()[5][0].isWater(), is(false));
		assertThat(subject.cells()[5][1].isWater(), is(false));
		assertThat(subject.cells()[5][2].isWater(), is(true));
		assertThat(subject.cells()[5][3].isWater(), is(true));
		assertThat(subject.cells()[5][4].isWater(), is(true));
		assertThat(subject.cells()[5][5].isWater(), is(false));
		assertThat(subject.cells()[5][6].isWater(), is(false));

		assertThat(subject.cells()[6][0].isWater(), is(false));
		assertThat(subject.cells()[6][1].isWater(), is(true));
		assertThat(subject.cells()[6][2].isWater(), is(true));
		assertThat(subject.cells()[6][3].isWater(), is(true));
		assertThat(subject.cells()[6][4].isWater(), is(true));
		assertThat(subject.cells()[6][5].isWater(), is(false));
		assertThat(subject.cells()[6][6].isWater(), is(false));

		assertThat(subject.cells()[7][0].isWater(), is(false));
		assertThat(subject.cells()[7][1].isWater(), is(false));
		assertThat(subject.cells()[7][2].isWater(), is(false));
		assertThat(subject.cells()[7][3].isWater(), is(false));
		assertThat(subject.cells()[7][4].isWater(), is(false));
		assertThat(subject.cells()[7][5].isWater(), is(false));
		assertThat(subject.cells()[7][6].isWater(), is(false));

		assertThat(subject.cells()[8][0].isWater(), is(false));
		assertThat(subject.cells()[8][1].isWater(), is(false));
		assertThat(subject.cells()[8][2].isWater(), is(false));
		assertThat(subject.cells()[8][3].isWater(), is(false));
		assertThat(subject.cells()[8][4].isWater(), is(false));
		assertThat(subject.cells()[8][5].isWater(), is(false));
		assertThat(subject.cells()[8][6].isWater(), is(false));

		assertThat(subject.cells()[9][0].isWater(), is(false));
		assertThat(subject.cells()[9][1].isWater(), is(false));
		assertThat(subject.cells()[9][2].isWater(), is(false));
		assertThat(subject.cells()[9][3].isWater(), is(false));
		assertThat(subject.cells()[9][4].isWater(), is(false));
		assertThat(subject.cells()[9][5].isWater(), is(false));
		assertThat(subject.cells()[9][6].isWater(), is(false));

	}

	@Test
	public void counts_waterUnitsIsZero_inCaseOfFlatStructure() {
		int[] input = {1, 1, 1, 1, 1, 1};

		subject = new Structure(input);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(0));
	}

	@Test
	public void counts_waterUnits_example() {
		Cell[][] cells = new Cell[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == j) { //4 water items
					cells[i][j] = new Cell(new Coordinates(i, j), WATER);
				} else {
					cells[i][j] = new Cell(new Coordinates(i, j), BLOCK);
				}
			}
		}

		subject = new Structure(cells);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(4));
	}

	@Test
	public void counts_waterUnits_example2() {
		int[] input = {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};
		subject = new Structure(input);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(17));

	}

	@Test
	public void counts_waterUnits_example_HillStructure() {
		int[] input = {5, 4, 3, 2, 1};
		subject = new Structure(input);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(0));

	}

	@Test
	public void counts_waterUnits_example_PyramidStructure() {
		int[] input = {1, 3, 5, 2, 1};
		subject = new Structure(input);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(0));
	}


	@Test
	public void counts_waterUnits_example_towerStructure() {
		int[] input = {5};
		subject = new Structure(input);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(0));
	}

	@Test
	public void counts_waterUnits_example_twoItemOnlyStructure() {
		int[] input = {5, 2};
		subject = new Structure(input);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(0));
	}

	@Test
	public void counts_waterUnits_example_CupStructure() {
		int[] input = {5, 2, 5};
		subject = new Structure(input);
		subject.rain();

		int waterUnits = subject.countWaterUnits();
		assertThat(waterUnits, is(3));
	}
}