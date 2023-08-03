package baseball.controller;

import baseball.controller.input.InningInput;
import baseball.model.Computer;
import baseball.model.Inning;
import baseball.view.output.Notification;

import java.util.ArrayList;

import static baseball.config.Config.NUMBER_COUNT;

public class GameContoller {
    public static void gameStart() {
        Notification.gameStart();
        ArrayList<Integer> answer = Computer.getNumbers(NUMBER_COUNT);
        inGame(answer);
    }

    private static void inGame(ArrayList<Integer> answer) {
        while (true) {
            ArrayList<Integer> input = InningInput.numberInput();
            Inning inning = new Inning(answer, input);
            Notification.numberResult(inning.getBall(), inning.getStrike());
            if (inning.getStrike() == 3) {
                restart();
                break;
            }

        }
    }

    private static void restart() {
        Notification.gameEnd();
        int restart = InningInput.restartInput();
        if (restart == 1) {
            ArrayList<Integer> answer = Computer.getNumbers(NUMBER_COUNT);
            inGame(answer);
        }
    }

}
