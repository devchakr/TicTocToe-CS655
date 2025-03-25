package project.service.impl;

import project.TicTacToeModel;
import project.service.BuilderPattern;

/**
 * Implementation of the Builder interface that builds a 3x3 Tic Tac Toe board.
 * This class is part of the Builder pattern, specifically handling the concrete steps of constructing
 * a Tic Tac Toe game board. It encapsulates the creation logic for the game board,
 * separating the construction complexity from the user.
 */
public class BuilderPatternImpl implements BuilderPattern {


  /* The Tic Tac Toe board represented as a 2D char array. */
  private char[][] gameBoard;

  /**
   * Builds a new Tic Tac Toe board by initializing a 2D char array of size 3x3
   * with empty cells represented by the '-' character.
   * This method encapsulates the board initialization logic, fulfilling the Builder pattern's role
   * by allowing the construction process to be customizable and isolated.
   */

  public void gameBoardMaker() {
    gameBoard = new char[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        gameBoard[i][j] = '-';
      }
    }
  }

  /**
   * Returns a new TicTacToe object with the previously built board.
   * This method provides the final product of the building process, a fully initialized TicTacToe game,
   * thereby separating the object's construction from its representation.
   * @return a TicTacToe object with the current state of the board.
   */

  public TicTacToeModel getTTT() {
    return new TicTacToeModel(gameBoard);
  }
}