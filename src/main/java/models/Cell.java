package models;

import java.lang.reflect.Array;

public class Cell {
    private boolean alive;
    private Array neighbors;

    public Cell(boolean alive, String coordinates) {
        this.alive = alive;
        this.neighbors = this.instantiateNeighbors(coordinates);
    }

    private Array instantiateNeighbors(String coordinates) {

    }

    public void toggleAlive() {
        if (alive = true) {
            alive = false;
        } else {
            alive = true;
        }
    }

    public boolean getAlive() {
        return alive;
    }

    public Array getNeighbors() {
        return neighbors;
    }
}
