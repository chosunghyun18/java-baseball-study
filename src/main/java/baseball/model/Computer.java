package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final ArrayList<Integer> answer;

    public Computer(int count){
        this.answer = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 9, count));
    }

    public ArrayList<Integer> getNumbers() {
        return answer;
    }
}
