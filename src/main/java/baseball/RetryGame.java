package baseball;

import camp.nextstep.edu.missionutils.Console;
import baseball.view.InputView;
;
import static baseball.validateInput.retryGameValidateInput;

public class RetryGame {

    //사용자에게 입력 받아서 게임 다시 시작 또는 종료
    public static boolean againGame() {
        //사용자에게 입력 받음
        InputView.printRestartMessage();
        String retryGameInput = Console.readLine();

        return retryGameValidateInput(retryGameInput);
    }
}
