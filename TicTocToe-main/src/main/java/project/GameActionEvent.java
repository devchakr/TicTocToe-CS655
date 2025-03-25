package project;

/**
 * A class representing a game event in TicTacToe.
 * This class contains a BoardResult object that represents
 * the result of a TicTacToe game.  * It is used to notify
 * EventListeners when a game has ended.
 */
public class GameActionEvent {
  /*
   The BoardResult representing the result of a TicTacToe game.
   */
  private BoardRES boardRES;


  /*
   Constructs a GameEvent object with the given BoardResult.
   @param boardResult the BoardResult representing
   the result of a TicTacToe game.
   */
  public GameActionEvent(BoardRES boardRES) {
    this.boardRES = boardRES;
  }


  /*
   Returns the BoardResult of this GameEvent.
   @return the BoardResult representing the result of a TicTacToe game.
   */
  public BoardRES getBoardResult() {
    return boardRES;
  }
}