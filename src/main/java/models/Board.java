package models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import models.Cell;

public class Board {
    private int boardSize;
    private LinkedHashMap<String, Cell> cellsOnBoard = new LinkedHashMap<>();

    public Board(int size){
        this.boardSize = size;
        this.setupCellsOnBoard();
    }

    public void printBoard() {
        String boardRow = "";
        for (int z = 0; z < boardSize; z++) {
            boardRow = boardRow + "_ ";
        }
        System.out.println("The board: ");
        for (int z = 0; z < boardSize; z++) {
            System.out.println(boardRow);
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    private void setupCellsOnBoard() {
        for (int z = 0; z < boardSize; z++) {
            for (int a = 0; a < boardSize; a++) {
                String cellKey = z + "-" + a;
                Boolean alive = false;
                int randomAlive = (int) (Math.random() * 10);
                if (randomAlive < 2) {
                    alive = true;
                }
                Cell newCell = new Cell(alive, cellKey, boardSize);
                cellsOnBoard.put(cellKey, newCell);
            }
        }
    }

    private void printCellsOnBoardValues() {
        Set<String> allKeys = cellsOnBoard.keySet();
        for (String key : allKeys) {
            System.out.println(cellsOnBoard.get(key).isAlive());
        }
    }
  
    public void printStateOfBoard() {
        Set<String> allKeys = cellsOnBoard.keySet();
        int rowCounter = 0;
        String printRow = "";
        for (String key : allKeys) {
            if (cellsOnBoard.get(key).isAlive()) {
                printRow = printRow + "O ";
            } else {
                printRow = printRow + "X ";
            }
            rowCounter++;
            if (rowCounter == boardSize) {
                System.out.println(printRow);
                rowCounter = 0;
                printRow = "";
            }
        }
    }

    public void printStateOfBoardNeighbors() {
        Set<String> allKeys = cellsOnBoard.keySet();
        int rowCounter = 0;
        String printRow = "";
        for (String key : allKeys) {
            if (cellsOnBoard.get(key).isAlive()) {
                printRow = printRow + cellsOnBoard.get(key).countLivingNeighbors(cellsOnBoard);
            } else {
                printRow = printRow + cellsOnBoard.get(key).countLivingNeighbors(cellsOnBoard);
            }
            rowCounter++;
            if (rowCounter == boardSize) {
                System.out.println(printRow);
                rowCounter = 0;
                printRow = "";
            }
        }
    }

    public LinkedHashMap<String, Cell> getCellsOnBoard() {
        return cellsOnBoard;
    }

    public void getNextGeneration(){
        Map newGeneration = new LinkedHashMap<String, Boolean>();
        Set<String> allKeys = cellsOnBoard.keySet();
        for( String key : allKeys) {
            Cell cell = cellsOnBoard.get(key);
            boolean newState = cell.determineNextState(cellsOnBoard);
            newGeneration.put(key, newState);
        }
        for (String key : allKeys) {
            boolean currentStateOfCell = cellsOnBoard.get(key).isAlive();
            Boolean newStateOfCell = (Boolean) newGeneration.get(key);
            if (newStateOfCell != currentStateOfCell) {
                cellsOnBoard.get(key).toggleAlive();
            }
        }
    }
}
