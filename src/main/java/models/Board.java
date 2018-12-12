package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Board {
    private int xaxis;

    public Board(){
        this.boardSetup();
    }

    public void boardSetup() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Welcome to the Game of Life!");
            System.out.println("Please enter the size for your board (1-10): ");
            xaxis = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Your board size is " + xaxis + " columns by " + xaxis + " rows.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void printBoard() {
        String boardRow = "";
        for (int z = 0; z < xaxis; z++) {
            boardRow = boardRow + "_ ";
        }
        System.out.println("The board: ");
        for (int z = 0; z < xaxis; z++) {
            System.out.println(boardRow);
        }
    }
}
