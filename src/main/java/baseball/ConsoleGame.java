package baseball;

import camp.nextstep.edu.missionutils.Console;

public interface ConsoleGame {

  static String getUserInput(String message) {
    if (message != null) {
      displayMessage(message);
    }
    return Console.readLine().trim();
  }

  static void displayMessage(String message) {
    System.out.println(message);
  }

  void initGame();

  void playGame();
}
