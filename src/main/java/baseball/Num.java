package baseball;
import java.util.List;
import java.util.ArrayList;

public class Num {
    private List<Integer> ball;

    public Num(String s) {

        this.ball = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char c = s.charAt(i);
            int digit = Character.getNumericValue(c);
            this.ball.add(digit);
        }
    }

    public List<Integer> getBall() {
        return this.ball;
    }
}
