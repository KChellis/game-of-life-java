package models;


import java.util.ArrayList;
import java.util.List;

public class Cell {
    private boolean alive;
    private List<String> neighbors;

    public Cell(boolean alive, String coordinates,int gridSize) {
        this.alive = alive;
        this.instantiateNeighbors(coordinates, gridSize);
    }

    private List<String> instantiateNeighbors(String coordinates, int gridSize) {
        String[] coordinateSplit = coordinates.split("-");
        Integer row = Integer.parseInt(coordinateSplit[0]);
        Integer column = Integer.parseInt(coordinateSplit[1]);
        List<String> neighbors = new ArrayList<String>();
        if(row > 0){
            neighbors.add((row-1) + "-" + column);
            if(column > 0){
                neighbors.add((row-1) + "-" + (column-1));
            }
            if(column < gridSize){
                neighbors.add((row-1) + "-" + (column+1));
            }
        }
        if(row < gridSize){
            neighbors.add((row+1) + "-" + column);
            if(column > 0){
                neighbors.add((row+1) + "-" + (column-1));
            }
            if(column < gridSize){
                neighbors.add((row+1) + "-" + (column+1));
            }
        }
        if(column > 0){
            neighbors.add(row + "-" + (column-1));
        }
        if(column < gridSize){
            neighbors.add(row + "-" + (column+1));
        }
        return neighbors;
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
