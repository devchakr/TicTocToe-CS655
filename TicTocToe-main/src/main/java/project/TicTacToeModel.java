package project;

/**
 * The TicTacToe class represents the game board for Tic Tac Toe
 * and provides methods for accessing and updating the board.
 * This class centralizes the game board management, making it a key part of the game's architecture,
 * though it doesn't specifically implement a formal design pattern. It is crucial for encapsulating the
 * game state and the logic for manipulating it.
 */
public class TicTacToeModel {
  /* The game board represented by a 2D array of characters. */
  private char[][] gameBoard;

  /**
   * Constructs a new TicTacToe object with the given board.
   * This constructor allows for initializing the game board with a specific state,
   * useful in scenarios like restoring a saved game or setting up a predetermined board for testing.
   * @param gameBoard the game board represented by a 2D array of characters
   */
  public TicTacToeModel(char[][] gameBoard) {
    this.gameBoard = gameBoard;
  }

  /**
   * Displays the current state of the game board.
   * This method prints the board to the console, allowing players to see the game's progress.
   */
  public void display() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(gameBoard[i][j] + " ");
      }
      System.out.println(); // Move to the next line after printing each row
    }
  }

  /**
   * Gets the character value of the cell at the given row and column on the game board.
   * This method allows retrieval of the board state at a specific cell, facilitating game logic like checking for wins.
   * @param row the row index of the cell
   * @param col the column index of the cell
   * @return the character value of the cell at the given row and column on the game board
   */
  public char getGrid(int row, int col) {
    return gameBoard[row][col];
  }

  /**
   * Sets the character value of the cell at the given row and column on the game board to the specified player character.
   * This method updates the board state, a crucial action during gameplay to record players' moves.
   * @param row the row index of the cell
   * @param col the column index of the cell
   * @param currentPlayer the character value of the current player (either 'X' or 'O')
   */
  public void setGrid(int row, int col, char currentPlayer) {
    gameBoard[row][col] = currentPlayer;
  }
}
