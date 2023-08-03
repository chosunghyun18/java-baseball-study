package baseball;

import java.util.List;

import static util.Message.START_GAME_MESSAGE;

public class Game {
    private final Computer computer;
    private final Judge judge;

    public Game(){
        this.computer = new Computer();
        this.judge = new Judge();
        System.out.println(START_GAME_MESSAGE);
    }

    //Computer에게 새로운 3자리수 생성 요청 & Compare 요청
    public void startGame(){
        List<Integer> computerNumber = computer.generateRandomNumber();
        judge.compare(computerNumber);
    }
}
