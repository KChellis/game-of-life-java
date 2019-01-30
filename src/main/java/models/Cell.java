package models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            if(column < gridSize-1){
                neighbors.add((row-1) + "-" + (column+1));
            }
        }
        if(row < gridSize-1){
            neighbors.add((row+1) + "-" + column);
            if(column > 0){
                neighbors.add((row+1) + "-" + (column-1));
            }
            if(column < gridSize-1){
                neighbors.add((row+1) + "-" + (column+1));
            }
        }
        if(column > 0){
            neighbors.add(row + "-" + (column-1));
        }
        if(column < gridSize-1){
            neighbors.add(row + "-" + (column+1));
        }
        return neighbors;
    }

    public void toggleAlive() {
        if (alive) {
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

    public Integer countLivingNeighbors(HashMap<String, Cell> board) {
        Integer count = 0;
        for( String neighbor : neighbors){
            if(board.get(neighbor).isAlive()){
                count += 1;
            }
        }
        return count;
    }

    public boolean determineNextState(HashMap<String,Cell> board) {
        boolean nextState = isAlive();
        Integer livingNeighbors = countLivingNeighbors(board);
        if(isAlive()) {
            if(livingNeighbors <2 || livingNeighbors >3) {
                nextState = false;
            }
        } else {
            if(livingNeighbors == 3){
                nextState = true;
            }
        }
        return nextState;
    }
}
