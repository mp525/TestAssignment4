Feature: A game of TicTacToe

  Scenario: Game starts
    Given a TicTacToe game
    When game starts
    Then a game board <gameboard> is made

  Scenario: Player can make a move
    Given a started TicTacToe game
    When player enters number <number>
    Then a move is made based on that number

  Scenario: AI can make a move
    Given a started TicTacToe game
    When player has entered a number
    Then AI will make a move that isn't the same as players move

  Scenario: Game can be finished
    Given player and ai has made moves
    When win conditions are met
    Then the game will be finished


