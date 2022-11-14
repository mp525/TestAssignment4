package com.teamrocket.Template.acceptance;

import com.teamrocket.Template.utility.TicTacToe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class TempDef {

    private TicTacToe game;
    private char[][] gameBoardActual;
    private int moveMade;
    private int playerMadeMove;
    private String resultMessage;

    @Given("a TicTacToe game")
    public void a_tic_tac_toe_game() {
        game = new TicTacToe();
    }

    @When("game starts")
    public void game_starts() {
        gameBoardActual = game.makeBoard();
    }
    @Then("a game board <gameboard> is made")
    public void a_game_board_gameboard_is_made() {
        assertTrue(gameBoardActual.length == 5);
    }

    @Given("a started TicTacToe game")
    public void aStartedTicTacToeGame() {
        game = new TicTacToe();
        game.makeBoard();
    }
    @When("player enters number <number>")
    public void player_enters_number_number() {
        int playerNum = 1;
        moveMade = game.makeMove(playerNum, "player");
    }
    @Then("a move is made based on that number")
    public void a_move_is_made_based_on_that_number() {
        assertTrue(moveMade == 1);
    }

    @When("player has entered a number")
    public void player_has_entered_a_number() {
        int playerMove = 1;
        playerMadeMove = game.makeMove(playerMove, "player");
    }
    @Then("AI will make a move that isn't the same as players move")
    public void ai_will_make_a_move_that_isn_t_the_same_as_players_move() {
        int aiMove = game.generateMove();
        int aiMadeMove = game.makeMove(aiMove, "AI");
        assertTrue(aiMadeMove != playerMadeMove);
    }

    @Given("player and ai has made moves")
    public void player_and_ai_has_made_moves() {
        game = new TicTacToe();
        game.makeBoard();
        generateGame();
    }

    private void generateGame() {
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
    }

    @When("win conditions are met")
    public void win_conditions_are_met() {
        resultMessage = game.checkWinner();
    }
    @Then("the game will be finished")
    public void the_game_will_be_finished() {
        assertTrue(resultMessage.equals("You win!"));
    }


}
