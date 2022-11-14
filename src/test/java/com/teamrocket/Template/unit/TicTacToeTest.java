package com.teamrocket.Template.unit;

import com.teamrocket.Template.utility.TicTacToe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        game.makeBoard();
    }

    @AfterEach
    void tearDown() {
        game = null;
    }

    @Test
    void shouldReturnStartBoard() {
        char[][] board = game.makeBoard();
        assertTrue(board != null);
    }

    @Test
    void shouldMakeMove() {
        game.makeMove(5, "player");
        char actual = game.getGameBoard()[2][2];
        assertEquals('X', actual);
    }

    @Test
    void aiShouldMakeMove() {
        int move = 9;
        game.makeMove(move, "AI");
        char actual = game.getGameBoard()[4][4];
        assertEquals('O', actual);
    }

    @Test
    void shouldGenerateMoveNotMade() {
        int playerMadeMove = game.makeMove(5, "player");
        int generated = game.generateMove();
        int aiMadeMove = game.makeMove(generated, "AI");
        assertTrue(playerMadeMove != aiMadeMove);
    }

    @Test
    void shouldShowWinMessage() {
        String resultMessage = generatePlayerWin();
        assertEquals("You win!", resultMessage);
    }

    @Test
    void shouldShowLoseMessage() {
        String resultMessage = generateAIWin();
        assertEquals("You lose!", resultMessage);
    }

    @Test
    void shouldShowTieMessage() {
        String resultMessage = generateTie();
        assertEquals("It's a tie!", resultMessage);
    }

    private String generatePlayerWin() {
        int[] playerMoves = new int[3];
        playerMoves[0] = 1;
        playerMoves[1] = 2;
        playerMoves[2] = 3;
        int[] aiMoves = new int[3];
        aiMoves[0] = 4;
        aiMoves[1] = 7;
        aiMoves[2] = 9;
        for (int i = 0; i < 3; i++) {
            game.makeMove(playerMoves[i], "player");
            game.makeMove(aiMoves[i], "AI");
        }

        String resultMessage = game.checkWinner();
        return resultMessage;
    }

    private String generateAIWin() {
        int[] playerMoves = new int[3];
        playerMoves[0] = 4;
        playerMoves[1] = 7;
        playerMoves[2] = 9;
        int[] aiMoves = new int[3];
        aiMoves[0] = 1;
        aiMoves[1] = 2;
        aiMoves[2] = 3;
        for (int i = 0; i < 3; i++) {
            game.makeMove(playerMoves[i], "player");
            game.makeMove(aiMoves[i], "AI");
        }

        String resultMessage = game.checkWinner();
        return resultMessage;
    }

    private String generateTie() {
        int[] playerMoves = new int[5];
        playerMoves[0] = 1;
        playerMoves[1] = 4;
        playerMoves[2] = 8;
        playerMoves[3] = 3;
        playerMoves[4] = 6;
        int[] aiMoves = new int[4];
        aiMoves[0] = 2;
        aiMoves[1] = 5;
        aiMoves[2] = 7;
        aiMoves[3] = 9;
        for (int i = 0; i < 5; i++) {
            game.makeMove(playerMoves[i], "player");
        }
        for (int i = 0; i < 4; i++) {
            game.makeMove(aiMoves[i], "AI");
        }

        String resultMessage = game.checkWinner();
        return resultMessage;
    }
}