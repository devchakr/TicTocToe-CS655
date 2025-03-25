package project.service;

import project.TicTacToeModel;

/**
 * The Builder interface for building a Tic Tac Toe game.
 * This interface is a part of the Builder pattern, which is used to construct a complex object step by step.
 * It abstracts the process of constructing a game board and allows for the creation of different representations
 * of a TicTacToe game.
 */
public interface BuilderPattern {
  /**
   * Method to build the game board. This method will be implemented to define how the board is constructed.
   */
  public void gameBoardMaker();

  /**
   * Method to retrieve the constructed TicTacToe object.
   * After the game board is built, this method provides the resulting TicTacToe object.
   * @return TicTacToe The completed TicTacToe game object.
   */
  public TicTacToeModel getTTT();
}