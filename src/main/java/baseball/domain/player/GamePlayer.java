package baseball.domain.player;

import baseball.domain.computer.Computer;
import baseball.domain.game.BaseBallGameRule;

public abstract class GamePlayer extends BaseBallGameRule {

    public abstract Boolean checkFinishGame();

    public abstract void fight(Computer computer);
}
