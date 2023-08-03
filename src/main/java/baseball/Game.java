package baseball;

import static util.Message.START_GAME_MESSAGE;

public class Game {
    private final Judge judge;

    public Game(){
        this.judge = new Judge();
    }

    public void startGame(){
        System.out.println(START_GAME_MESSAGE);
        judge.compare();
    }
}
