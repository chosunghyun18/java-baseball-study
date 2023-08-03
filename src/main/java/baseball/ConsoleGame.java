package baseball;

import camp.nextstep.edu.missionutils.Console;

public abstract class ConsoleGame {

  static String getUserInput(String message) {
    if (message != null) {
      System.out.print(message);
    }
    return Console.readLine().trim();
  }

  static void displayMessage(String message) {
    System.out.println(message);
  }

  abstract void playGame();
}
