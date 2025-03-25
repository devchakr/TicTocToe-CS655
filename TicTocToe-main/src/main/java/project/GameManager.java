package project;

import project.service.BuilderPattern;

/**
 * A Tic Tac Toe Director class that orchestrates the construction of a Tic Tac Toe game.
 * This class demonstrates the Director part of the Builder pattern, which is responsible for
 * managing the construction steps defined by the Builder interface.
 */
public class GameManager {
  private BuilderPattern builderPattern;
  /**
   * Constructs a Director with a specific Builder instance.
   * The Director uses this builder to construct a Tic Tac Toe game,
   * encapsulating the order of construction steps.
   * @param builderPattern The Builder instance used to build the game board.
   */
  public GameManager(BuilderPattern builderPattern) {
    this.builderPattern = builderPattern;
  }
  /**
   * Directs the builder to construct the game board.
   * This method demonstrates the directing function in the Builder pattern,
   * controlling the construction process and utilizing the Builder's methods
   * to achieve the desired object configuration.
   */
  public void buildGame() {
    builderPattern.gameBoardMaker();
  }
}