package baseball;

import java.util.List;

public abstract class Game {
    List<Integer> computerValue;

    public Game(List<Integer> computerValue) {
        this.computerValue = computerValue;
    }

    public void gameStart() {
        System.out.println("게임을 시작합니다.");
    }
}