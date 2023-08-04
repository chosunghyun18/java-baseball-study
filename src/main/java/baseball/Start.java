package baseball;

import baseball.view.OutputView;

public class Start {
    public void startGame() {
        do{
            Game game = new Game();
            game.newGame();
        }while(RetryGame.againGame());
    }
}
