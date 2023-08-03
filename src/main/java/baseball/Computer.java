package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static baseball.util.Message.*;

public class Computer {

    //랜덤 숫자 생성 메서드
    public static List<Integer> generateRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < TOTAL_BALL_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
