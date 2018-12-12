import models.Cell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        String boardSize;
        boardSize = boardSetup();
        System.out.println(boardSize);
        printBoard(boardSize);
    }

    public static String boardSetup() {
        String returnSize = "0";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Welcome to the Game of Life!");
            System.out.println("Please enter the number of columns for your board (1-10): ");
            int xaxis = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Please enter the number of rows for your board (1-10): ");
            int yaxis = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Your board size is " + xaxis + " columns by " + yaxis + " rows.");
            returnSize = xaxis + "-" + yaxis;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return returnSize;
    }

    public static void printBoard(String boardSize) {
        String boardRow = "";
        int xaxis = Character.getNumericValue(boardSize.charAt(0));
        int yaxis = Character.getNumericValue(boardSize.charAt(2));
        for (int z = 0; z < xaxis; z++) {
            boardRow = boardRow + "_ ";
        }
        System.out.println("The board: ");
        for (int z = 0; z < yaxis; z++) {
            System.out.println(boardRow);
        }
    }
}