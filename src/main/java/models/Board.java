package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

import models.Cell;

public class Board {
    private int boardSize;
    private HashMap<String, Cell> cellsOnBoard = new HashMap<>();

    public Board(){
        this.boardSetup();
        this.setupCellsOnBoard();
    }

    public void boardSetup() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Welcome to the Game of Life!");
            System.out.println("Please enter the size for your board (1-10): ");
            boardSize = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Your board size is " + boardSize + " columns by " + boardSize + " rows.");
        } catch(IOException e) {
            e.printStackTrace();
        }
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
            System.out.println(cellsOnBoard.get(key));
        }
    }
}
