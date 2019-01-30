import models.Cell;
import models.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        int boardSize = 0;
        Board gameBoard;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Welcome to the Game of Life!");
            System.out.println("Please enter the size for your board (1-10): ");
            boardSize = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Your board size is " + boardSize + " columns by " + boardSize + " rows.");
        } catch(IOException e) {
            e.printStackTrace();
        }
        gameBoard = new Board(boardSize);
//        gameBoard.printBoard();
        gameBoard.printStateOfBoard();
        System.out.println("----------------------------------------------------");
        gameBoard.printStateOfBoardNeighbors();
        gameBoard.getNextGeneration();
        System.out.println("----------------------------------------------------");
        gameBoard.printStateOfBoard();
    }


}