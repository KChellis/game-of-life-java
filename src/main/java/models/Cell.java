package models;


import java.util.ArrayList;
import java.util.List;

public class Cell {
    private boolean alive;
    private List<String> neighbors;

    public Cell(boolean alive, String coordinates,int gridSize) {
        this.alive = alive;
        this.neighbors= new ArrayList<>();
        this.instantiateNeighbors(coordinates, gridSize);
    }

    private List<String> instantiateNeighbors(String coordinates, int gridSize) {
        String[] coordinateSplit = coordinates.split("-");
        Integer row = Integer.parseInt(coordinateSplit[0]);
        Integer column = Integer.parseInt(coordinateSplit[1]);
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

    public boolean isAlive() {
        return alive;
    }

    public List<String> getNeighbors() {
        return neighbors;
    }
}
