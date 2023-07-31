package baseball.domain.ball;

public class ComputerBall {
    private Ball ball;
    public ComputerBall(Integer givenNumber) {
        this.ball = new Ball(givenNumber);
    }
    public Ball getBall() {
        return ball;
    }
}
