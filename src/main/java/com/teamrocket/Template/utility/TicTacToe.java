package com.teamrocket.Template.utility;

import java.util.*;

public class TicTacToe {
    private char[][] gameBoard;

    private ArrayList<Integer> playerPositions = new ArrayList<>();
    private ArrayList<Integer> aiPositions = new ArrayList<>();

    public char[][] makeBoard() {
        char[][] board = {{' ', '|', ' ', '|', ' '},
                          {'-', '+', '-', '+', '-'},
                          {' ', '|', ' ', '|', ' '},
                          {'-', '+', ' ', '+', '-'},
                          {' ', '|', ' ', '|', ' '}};
        this.gameBoard = board;
        return board;
    }

    public void start() {
        makeBoard();
        showBoard();
        boolean gameOngoing = true;
        List<Integer> movesMade = new ArrayList<>();
        while (gameOngoing) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number (1-9)");
            int move = scanner.nextInt();
            while (playerPositions.contains(move) || aiPositions.contains(move)){
                System.out.println("Can't place a piece there. Try again.");
                move = scanner.nextInt();
            }
            makeMove(move, "player");
            movesMade.add(move);
            int aiMove = generateMove();
            if(aiMove == 0){
                String result = checkWinner();
                System.out.println(result);
                gameOngoing = false;
            }
            makeMove(aiMove, "AI");
            showBoard();
            String result = checkWinner();
            System.out.println(result);
            if(result.equals("You win!") || result.equals("You lose!") || result.equals("It's a tie!")) {
                gameOngoing = false;
            }
        }
    }

    public int generateMove() {
        boolean occupiedMove = true;
        int aiMove = 0;
        while (occupiedMove){
            Random random = new Random();
            aiMove = random.nextInt(9) + 1;
            if (playerPositions.contains(aiMove) || aiPositions.contains(aiMove)) {
                occupiedMove = true;
            } else {
                occupiedMove = false;
            }
            if (playerPositions.size() + aiPositions.size() == 9){
                return 0;
            }
        }
        return aiMove;
    }

    public void showBoard() {
        for (char[] row : gameBoard
             ) {
            for (char symbol : row
                 ) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public String checkWinner() {
        String resultMessage = "";
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winConditions = new ArrayList<>();
        winConditions.add(topRow);
        winConditions.add(midRow);
        winConditions.add(botRow);
        winConditions.add(leftCol);
        winConditions.add(midCol);
        winConditions.add(rightCol);
        winConditions.add(cross1);
        winConditions.add(cross2);

        for (List list : winConditions
             ) {
            if(playerPositions.containsAll(list)){
                resultMessage = "You win!";
            } else if (aiPositions.containsAll(list)){
                resultMessage = "You lose!";
            } else if(playerPositions.size() + aiPositions.size() == 9) {
                resultMessage = "It's a tie!";
            }
        }
        return resultMessage;
    }

    public int makeMove(int move, String user) {
        char symbol = 'X';
        if(user == "AI") {
            symbol = 'O';
            aiPositions.add(move);
        } else {
            playerPositions.add(move);
        }
        switch (move) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
        return move;
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public ArrayList<Integer> getPlayerPositions() {
        return playerPositions;
    }

    public void setPlayerPositions(ArrayList<Integer> playerPositions) {
        this.playerPositions = playerPositions;
    }

    public ArrayList<Integer> getAiPositions() {
        return aiPositions;
    }

    public void setAiPositions(ArrayList<Integer> aiPositions) {
        this.aiPositions = aiPositions;
    }
}
