package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    public static ArrayList<Integer> getNumbers(int count) {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 9, count));
    }
}
