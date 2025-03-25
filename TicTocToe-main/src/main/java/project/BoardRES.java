package project;

/**
 * The BoardResult class represents the outcome of a tic-tac-toe game.
 * It contains information about whether the game was won or drawn.
 * This class can be seen as an implementation of the Data Transfer Object (DTO) pattern,
 * used to encapsulate the data attributes of a game result in one single object,
 * simplifying the passing of data across the system.
 */
public class BoardRES {
  private boolean youWon;
  private boolean stalemate;

  /*
   * Constructs a new BoardResult with the given youWon and stalemate flags.
   * @param youWon true if the game was won, false otherwise
   * @param stalemate true if the game was drawn, false otherwise
   */
  public BoardRES(boolean youWon, boolean stalemate) {
    this.youWon = youWon;
    this.stalemate = stalemate;
  }

  /*
   * Returns true if the game was won, false otherwise.
   * @return true if the game was won, false otherwise
   */
  public boolean isYouWon() {
    return youWon;
  }

  /*
   * Returns true if the game was drawn, false otherwise.
   * @return true if the game was drawn, false otherwise
   */
  public boolean isStalemate() {
    return stalemate;
  }
}
