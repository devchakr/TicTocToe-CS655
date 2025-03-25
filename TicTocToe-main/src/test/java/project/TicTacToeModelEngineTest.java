package project;

import junit.framework.TestCase;

public class TicTacToeModelEngineTest extends TestCase {

  public void testAttemptInvalidMove() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();

    // Try to play on an occupied cell
    game.startGame(0, 0); // X starts and plays at (0,0)
    game.startGame(0, 0); // O tries to play at the same spot
    assertFalse(game.isGameOver());
    assertEquals('O', game.getCurrentPlayer()); // O's turn again due to invalid move
  }

  public void testSequentialMoves() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();

    // Players taking turns correctly
    game.startGame(0, 0); // X
    game.startGame(0, 1); // O
    game.startGame(0, 2); // X
    assertFalse(game.isGameOver());
    assertEquals('O', game.getCurrentPlayer()); // Still O's turn
  }

  public void testOWinningScenario() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();

    // Sequence of moves where O wins
    game.startGame(0, 0); // X
    game.startGame(1, 0); // O
    game.startGame(0, 1); // X
    game.startGame(1, 1); // O
    game.startGame(0, 2); // X
    game.startGame(1, 0); // O
    game.startGame(1, 1); // X
    game.startGame(2, 2); // O
    game.startGame(1, 2); // X
    game.startGame(2, 0); // O
    game.startGame(2, 1); // X

    assertTrue(game.isGameOver());
    assertEquals('O', game.getCurrentPlayer());
  }

  public void testDraw() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();

    // Play moves to result in a draw
    game.startGame(0, 0); // X
    game.startGame(0, 1); // O
    game.startGame(0, 2); // X
    game.startGame(1, 0); // O
    game.startGame(1, 1); // X
    game.startGame(2, 2); // O
    game.startGame(1, 2); // X
    game.startGame(2, 0); // O
    game.startGame(2, 1); // X

    // Check game status after draw
    assertTrue(game.isGameOver());
    assertFalse(game.checkForWin());
    assertTrue(game.isitaStalemate());
  }
  public void testXVictoryTopRow() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();

    // X winning on top row
    game.startGame(0, 0); // X
    game.startGame(2, 0); // O
    game.startGame(1, 1); // X
    game.startGame(2, 1); // O
    game.startGame(2, 2); // X

    assertTrue(game.isGameOver());
    assertEquals('O', game.getCurrentPlayer());
  }

  public void testCompleteDrawGame() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();

    // All moves made without a winner
    game.startGame(0, 0); // X
    game.startGame(0, 1); // O
    game.startGame(0, 2); // X
    game.startGame(1, 0); // O
    game.startGame(1, 1); // X
    game.startGame(2, 2); // O
    game.startGame(1, 2); // X
    game.startGame(2, 0); // O
    game.startGame(2, 1); // X

    assertTrue(game.isGameOver());
    assertFalse(game.checkForWin());
    assertTrue(game.isitaStalemate());
  }

  public void testIllegalCoordinates() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();
    try {
      game.startGame(-1, 0); // Invalid move
      fail("Should have thrown an exception for out-of-bounds coordinates");
    } catch (IndexOutOfBoundsException e) {
      // Expected exception
    }
    assertFalse(game.isGameOver());
    assertEquals('X', game.getCurrentPlayer()); // Still X's turn
  }

  public void testWinningDiagonalFromTopLeft() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();
    game.startGame(0, 0); // X
    game.startGame(0, 1); // O
    game.startGame(1, 1); // X
    game.startGame(0, 2); // O
    game.startGame(2, 2); // X wins diagonally
    assertTrue(game.isGameOver());
    assertEquals('O', game.getCurrentPlayer()); // Game over, but check last valid player
  }

  public void testChangePlayerAfterValidMove() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();
    game.startGame(0, 0); // X
    assertEquals('O', game.getCurrentPlayer()); // Should switch to O
    game.startGame(0, 1); // O
    assertEquals('X', game.getCurrentPlayer()); // Should switch back to X
  }

  public void testWinningVerticalColumn() {
    UpdateNotifierImpl game = new UpdateNotifierImpl();
    game.startGame(0, 0); // X
    game.startGame(0, 1); // O
    game.startGame(1, 0); // X
    game.startGame(1, 1); // O
    game.startGame(2, 0); // X wins with vertical column 0
    assertTrue(game.isGameOver());
    assertEquals('O', game.getCurrentPlayer()); // Check for player when game ended
  }
}
