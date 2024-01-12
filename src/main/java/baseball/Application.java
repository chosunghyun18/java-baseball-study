package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 상대방(컴퓨터) 값 입력받기
        List<Integer> computerValue = new ArrayList<>();
        while (computerValue.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerValue.contains(randomNum)) {
                computerValue.add(randomNum);
            }
        }

        Game game = new BaseballGame(computerValue);
        game.gameStart();
    }
}
