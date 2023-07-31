package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    private ArrayList<Integer> answer;
    private ArrayList<Integer> input;
    private int strike;
    private int ball;

    public Inning(ArrayList<Integer> answer, ArrayList<Integer> input) {
        this.answer = answer;
        this.input = input;
        this.strike = checkSameNumberandOrder();
        this.ball = checkSameNumber() - strike;
    }


    private int checkSameNumber() {
        List<Integer> answerList = new ArrayList<>(answer);
        List<Integer> inputList = new ArrayList<>(input);
        answerList.retainAll(inputList);
        return answerList.size();
    }

    private int checkSameNumberandOrder() {
        int count = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(input.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
