package baseball.view.input;

import baseball.util.Convertion;
import baseball.view.output.Notification;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class InningInput {
    private ArrayList<Integer> numberInput() {
        Notification.numberInput();
        String input = Console.readLine();
        return Convertion.stringToArrayList(input);
    }
    private int restartInput() {
        Notification.gameRestart();
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}