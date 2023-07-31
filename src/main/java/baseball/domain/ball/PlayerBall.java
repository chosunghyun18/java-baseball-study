package baseball.domain.ball;

import baseball.domain.game.BaseBallGameRule;

public class PlayerBall extends  BaseBallGameRule{
    private Ball ball;
    public PlayerBall(Integer givenNumber) {
        rangeCheck(givenNumber);
        this.ball = new Ball(givenNumber);
    }
    public void rangeCheck(Integer numberGiven) {
        if( minValueOfBall> numberGiven || maxValueOfBall < numberGiven) {
            throw new IllegalArgumentException("Error " + numberGiven + "out of range rule");
        }
    }
    public Boolean equals(ComputerBall computerBall){
        if(ball.equals(computerBall.getBall())) return true;
        return false;
    }
}
