package baseball;

import static util.Message.*;

public class RetryGame {
    private final String retryGameInput;

    public RetryGame(String retryGameInput){
        this.retryGameInput = retryGameInput;
    }

    //입력 유효 판단
    public boolean validateInput() throws IllegalArgumentException {
        if (retryGameInput.equals(RESTART_GAME_NUMBER))
            return true;
        else if (!retryGameInput.equals(END_GAME_NUMBER))
            throw new IllegalArgumentException(RESTART_MESSAGE_ERROR);
        return false;
    }
}
