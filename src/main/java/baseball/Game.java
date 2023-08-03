package baseball;

import baseball.view.OutputView;

public class Game {
    private final Judge judge;

    public Game(){
        this.judge = new Judge();
    }

    public void startGame(){
        OutputView.startGameMessage();
        judge.compare();
    }
}
