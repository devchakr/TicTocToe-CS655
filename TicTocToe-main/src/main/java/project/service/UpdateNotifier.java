package project.service;

import project.GameActionEvent;

/**
 * The Notifier interface defines a contract for objects that are interested in receiving updates
 * about the state of a game. This interface should be implemented by any class that wants to
 * be notified about game events, aligning with the Observer pattern.
 *
 * Note: The name 'Notifier' usually implies the role of notifying others. If this interface is meant
 * for objects that receive notifications, a name like 'Observer' or 'GameEventListener' might be more
 * appropriate.
 */
public interface UpdateNotifier {

  /**
   * Method to update the observer with a new game gameEvent.
   * This method is called to notify the observer about changes or events within the game,
   * such as a game ending or a turn being completed.
   * @param gameActionEvent The GameEvent object containing the details of the gameEvent.
   */
  public void notifyUpdate(GameActionEvent gameActionEvent);
}
