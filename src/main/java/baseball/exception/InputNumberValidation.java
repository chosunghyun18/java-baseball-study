package baseball.exception;

import java.util.Arrays;

import static baseball.config.Config.NUMBER_COUNT;
import static baseball.config.Config.RESTART_NUMBER_COUNT;

public class InputNumberValidation {

    public static void checkNumberLength(String input) {
        if (input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자는"+ NUMBER_COUNT + "자리여야 합니다.");
        }
    }
    public static void checkRestartNumberLength(String input) {
        if (input.length() != RESTART_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자는"+ RESTART_NUMBER_COUNT + "자리여야 합니다.");
        }
    }

    public static void isNumeric(String str) {
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값은 숫자여야 합니다.");
        }
    }
}
