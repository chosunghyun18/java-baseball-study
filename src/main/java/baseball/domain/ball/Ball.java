package baseball.domain.ball;

import baseball.domain.game.BaseBallGameRule;
import java.util.Objects;

class Ball extends BaseBallGameRule {
    private final Integer ball;

    public Ball(Integer givenNumber) {
        this.ball = Objects.requireNonNull(givenNumber);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ball other = (Ball) obj;
        return ball.equals(other.ball);
    }

    @Override
    public int hashCode() {
        return ball.hashCode();
    }
}
