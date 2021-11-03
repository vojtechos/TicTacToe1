package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static char[] board = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
    private static int[] playerBoard = new int[9];
    private static int round = 0;
    private static int[][] combinations = {
            {0, 1, 2},
            {3, 4, 5},
            {3, 7, 8},
            {0, 4, 8},
            {2, 4, 6},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8}
    };

    public static void printBoard() {
        for (int i = 0; i < board.length; i += 3) {
            System.out.println(board[i] + " | " + board[i + 1] + " | " + board[i + 2]);
        }
    }

    public static void main(String[] args) {
        char bruh;
        while (true) {
            printBoard();
            userInput();
            bruh = checkWin();
            if (bruh != ' ') {
                return;
            }
            if (round == 9) {
                System.out.println("Draw");
                return;
            }
        }
    }

    public static void userInput() {
        System.out.print("Player: " + (round % 2 == 0 ? "O: " : "X: "));
        int position = sc.nextInt();
        if (!Character.isDigit(board[position])) {
            System.out.println("Invalid Input");
            return;
        }
        board[position] = round % 2 == 0 ? 'O' : 'X';
        round++;
    }

    public static char checkWin() {
        int X, O;
        for (int i = 0; i < combinations.length; i++) {
            X = 0;
            O = 0;
            for (int j = 0; j < combinations[i].length; j++) {
                if (board[combinations[i][j]] == 'X') {
                    X++;
                }
                if (board[combinations[i][j]] == 'O') {
                    O++;
                }
            }
            if (X == 3) {
                System.out.println("X player wins!");
                return 'X';
            }
            if (O == 3) {
                System.out.println("O player wins!");
                return 'O';
            }
        }
        return ' ';
    }
}
