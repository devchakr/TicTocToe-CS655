package project;

import project.service.BuilderPattern;
import project.service.UpdateNotifier;
import project.service.impl.BuilderPatternImpl;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a game of Tic Tac Toe. The game board is built using a
 * TicTacToeBuilder and the game progresses as players take turns
 * playing their moves until a win or a draw is reached.
 * The game can be played by calling the play() method with the
 * row and column of the cell to be played.
 * The game status can be checked using isGameOver()
 * and getCurrentPlayer() methods.
 * The game can be listened to for changes in the board
 * status by adding an EventListener.
 */
public class UpdateNotifierImpl implements UpdateNotifier {
  private GameManager gameManager;
  private BuilderPattern builderPattern;
  private TicTacToeModel ticTacToeModel;
  private char currentPlayer;
  private boolean isGameOver;


  /**
   * Constructs a new Tic Tac Toe game by initializing
   * the builder and director objects, building the game board,
   * and setting the current player to 'X'.
   */
  public UpdateNotifierImpl() {
    builderPattern = new BuilderPatternImpl();
    gameManager = new GameManager(builderPattern);
    gameManager.buildGame();
    ticTacToeModel = builderPattern.getTTT();
    currentPlayer = 'X';
    isGameOver = false;
  }


  /**
   * Plays a move in the TicTacToe game given a row and column.
   * Checks if the game is over or if the cell is already
   * occupied before placing the move.
   * Changes the currentPlayer and checks the game status
   * after placing the move.
   * @param row The row of the cell to place the move.
   * @param col The column of the cell to place the move.
   */
  public void startGame(int row, int col) {
    if (isGameOver) {
      System.out.println("Game over!");
      return;
    }
    if (ticTacToeModel.getGrid(row, col) != '-') {
      System.out.println("Cell occupied try some other position.");
      return;
    }
    ticTacToeModel.setGrid(row, col, currentPlayer);
    ticTacToeModel.display();
    checkGameStatus();
    currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
  }



  private void checkGameStatus() {
    boolean Winner = checkForWin();
    boolean stalemate = isitaStalemate();
    if (Winner || stalemate) {
      isGameOver = true;
      BoardRES score = new BoardRES(Winner, stalemate);
      notifyListeners(score);
    }
  }


  /*
   Checks the game status by calling checkForWin
    and checkForDraw. If the game is won or drawn,
    sets isGameOver to true, creates a BoardResult
    object, and notifies all listeners with a
    GameEvent containing the BoardResult.
   */
  boolean checkForWin() {
    // check columns
    for (int j = 0; j < 3; j++) {
      if (ticTacToeModel.getGrid(0, j) == currentPlayer && ticTacToeModel
          .getGrid(1, j) == currentPlayer && ticTacToeModel
          .getGrid(2, j) == currentPlayer) {
        return true;
      }
    }
    // check diagonals
    if (ticTacToeModel.getGrid(0, 0) == currentPlayer && ticTacToeModel
        .getGrid(1, 1) == currentPlayer && ticTacToeModel
        .getGrid(2, 2) == currentPlayer) {
      return true;
    }

    return false;
  }


  /*
   Checks if the game has ended in a draw.
   Checks if all cells on the board are occupied.
   @return True if the game has ended in a draw, false otherwise.
   */
  boolean isitaStalemate() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (ticTacToeModel.getGrid(i, j) == '-') {
          return false;
        }
      }
    }
    return true;
  }

  /* A list of EventListeners to be notified when the game state changes. */
  private List<UpdateNotifier> updateNotifiers = new ArrayList<>();


  /* Adds a new EventListener to the list of listeners.
   @param notifiers the notifiers to add   */
  public void addListener(UpdateNotifier notifiers) {
    updateNotifiers.add(notifiers);
  }

  /* Removes an EventListener from the li
  st of listeners.
   @param listener the listener to remove  */
  public void removeListener(UpdateNotifier listener) {
    updateNotifiers.remove(listener);
  }


  /* Notifies all event listeners of a board result.
   @param result the board result to notify listeners */
  private void notifyListeners(BoardRES result) {
    for (UpdateNotifier listener : updateNotifiers) {
      listener.notifyUpdate(new GameActionEvent(result));
    }
  }


  /* Updates the game state based on a game event.
   @param event the game event to update the game state with  */
  @Override
  public void notifyUpdate(GameActionEvent gameActionEvent) {
    if (gameActionEvent.getBoardResult().isYouWon()) {
      System.out.println("Player " + currentPlayer + " wins!");
    } else if (gameActionEvent.getBoardResult().isStalemate()) {
      System.out.println("Game ends in a draw.");
    }
  }


  /* Gets the current player. @return the current player */
  public char getCurrentPlayer() {
    return currentPlayer;
  }

  /* Checks if the game is over.
  @return true if the game is over, false otherwise  */
  public boolean isGameOver() {
    return isGameOver;
  }


}
