package models;

import java.util.HashMap;
import java.util.Set;

import models.Cell;

public class Board {
    private int boardSize;
    private HashMap<String, Cell> cellsOnBoard = new HashMap<>();

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
        this.printCellsOnBoardValues();
    }

    private void printCellsOnBoardValues() {
        Set<String> allKeys = cellsOnBoard.keySet();
        for (String key : allKeys) {
            System.out.println(cellsOnBoard.get(key).isAlive());
        }
    }

    public HashMap<String, Cell> getCellsOnBoard() {
        return cellsOnBoard;
    }
}
