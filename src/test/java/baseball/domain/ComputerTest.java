package baseball.domain;

import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void setUpBalls_Size_Test() {
        Computer computer =Computer.startComputer();
        Set<Ball> balls = computer.getBalls();
        for(Ball ball : balls) {
            balls.add(new Ball(ball.getValueForTest()));
        }
        Assertions.assertEquals(balls.size(),computer.maxNumberOfBallsAmount);
    }

    @Test
    void pickNumber_Test() {
    }
}
