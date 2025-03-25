package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

  /**
   * The main class for running a game of Tic Tac Toe.
   * This is where the game loop is managed, and player interactions are handled,
   * somewhat akin to the Command pattern where player commands are translated into actions.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean wantToPlayAgain = true;
    do {
      UpdateNotifierImpl gameTTT = new UpdateNotifierImpl(); // Instantiate a new gameTTT
      gameTTT.addListener(gameTTT); // Add itself as a listener for gameTTT events (Observer pattern)

      while (!gameTTT.isGameOver()) {
        System.out.print("Player" +  gameTTT.getCurrentPlayer() + "Turn: enter your move between 1 to 9 ");
        int pos = 0;
        while (true) {
          try {
            pos = sc.nextInt();
            if (pos < 1 || pos > 9) {
              throw new InputMismatchException();
            }
            break;
          } catch (InputMismatchException e) {
            System.out.println("wrong numbers only enter numbers 1 to 9");
            sc.nextLine(); // consume the remaining newline character
          }
        }
        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;
        gameTTT.startGame(row, col);
      }
      System.out.println("Its all over");
      System.out.print("want to try to win agian y or n");
      String input = sc.next();
      while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
        System.out.println("Only tell me y or n");
        input = sc.next();
      }
      wantToPlayAgain = input.equalsIgnoreCase("y"); // Determine if the gameTTT should restart
    } while (wantToPlayAgain);
    sc.close();
  }


}
