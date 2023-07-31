package baseball.domain;

abstract public class BaseBallGameRule {

    protected static final String GAME_NAME = "숫자 야구";
    protected static int maxNumberOfBallsAmount = 3;
    protected int minValueOfBall = 1;
    protected int maxValueOfBall = 9;
    protected static int restartGameValue = 1;
    protected static int endGameValue = 2;
    protected int strikeHit = 1;
    protected int ballHit = 2;
    protected int nothingHit = 0;
}
