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
        String resultMessage = generateGame();

        assertEquals("You win!", resultMessage);
    }

    private String generateGame() {
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
}