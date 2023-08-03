package baseball;

import camp.nextstep.edu.missionutils.Console;
import baseball.view.InputView;

import static baseball.util.Message.*;

public class RetryGame {

    //사용자에게 입력 받아서 게임 다시 시작 또는 종료
    public static boolean againGame() {
        //사용자에게 입력 받음
        InputView.printRestartMessage();
        String retryGameInput = Console.readLine();

        return validateInput(retryGameInput);
    }

    //입력 유효 판단
    public static boolean validateInput(String retryGameInput) throws IllegalArgumentException {
        if (retryGameInput.equals(RESTART_GAME_NUMBER))
            return true;
        else if (!retryGameInput.equals(END_GAME_NUMBER))
            throw new IllegalArgumentException(RESTART_MESSAGE_ERROR);
        return false;
    }
}
