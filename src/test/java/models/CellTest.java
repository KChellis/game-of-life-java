package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void instantiatesAsCell() {
        Cell testCell = new Cell(false, "1-1",10);
        assertTrue(testCell instanceof Cell);
    }

    @Test
    public void instantiatesAWithNeighbors() {
        Cell testCell = new Cell(false, "1-1",10);
        List<String> neighbors = new ArrayList<>();
        neighbors.add("0-1");
        neighbors.add("0-0");
        neighbors.add("0-2");
        neighbors.add("2-1");
        neighbors.add("2-0");
        neighbors.add("2-2");
        neighbors.add("1-0");
        neighbors.add("1-2");
        assertEquals(neighbors, testCell.getNeighbors());
    }

    @Test
    public void handlesEdgeCells() {
        Cell testCell = new Cell(false, "0-0",10);
        List<String> neighbors = new ArrayList<>();
        neighbors.add("1-0");
        neighbors.add("1-1");
        neighbors.add("0-1");
        assertEquals(neighbors, testCell.getNeighbors());
    }

    @Test
    public void isAlive() {
        Cell testCell = new Cell(false, "1-1",10);
        assertEquals(false, testCell.isAlive());
    }

    @Test
    public void toggleAlive() {
        Cell testCell = new Cell(false, "1-1",10);
        testCell.toggleAlive();
        assertEquals(true, testCell.isAlive());
    }

    @Test
    public void countLivingNeighbors() {
    }
}