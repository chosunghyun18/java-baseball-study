package baseball;

import java.util.List;

public class BaseballGame extends Game{

    public BaseballGame(List<Integer> computerValue) {
        super(computerValue);
    }

    @Override
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        inputNum();
    }

    @Override
    public void inputNum() {
        super.inputNum();
    }

    @Override
    public void gameEnd() {
        super.gameEnd();
    }
}
