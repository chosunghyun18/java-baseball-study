package baseball;

public class RetryGame {
    private final String retryGameInput;

    public RetryGame(String retryGameInput){
        this.retryGameInput = retryGameInput;
    }

    //입력 유효 판단
    public boolean validateInput() throws IllegalArgumentException {
        if (retryGameInput.equals("1"))
            return true;
        else if (!retryGameInput.equals("2"))
            throw new IllegalArgumentException("1 또는 2의 값을 입력하세요.");
        return false;
    }
}
