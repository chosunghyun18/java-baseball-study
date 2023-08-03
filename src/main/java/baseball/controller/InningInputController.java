package baseball.controller;

import baseball.exception.InputNumberValidation;
import baseball.util.Convertion;
import baseball.view.output.Notification;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class InningInputController {
    public static ArrayList<Integer> numberInput() {
        Notification.numberInput();
        String input = Console.readLine();
        InputNumberValidation.checkNumberLength(input);
        InputNumberValidation.isNumeric(input);
        return Convertion.stringToArrayList(input);
    }
    public static int restartInput() {
        Notification.gameRestart();
        String input = Console.readLine();
        InputNumberValidation.isNumeric(input);
        InputNumberValidation.checkRestartNumberLength(input);
        return Integer.parseInt(input);
    }
}