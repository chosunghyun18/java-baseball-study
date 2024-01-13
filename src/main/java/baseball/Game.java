package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public abstract class Game {
    List<Integer> computerValue;

    public Game(List<Integer> computerValue) {
        this.computerValue = computerValue;
    }

    public void gameStart() {
        System.out.println("게임을 시작합니다.");
    }

    public void inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        String[] splitInput = input.split("");
        Integer[] inputArray = new Integer[3];

        for (int i = 0; i < 3; i++) {
            inputArray[i] = Integer.parseInt(splitInput[i]);
        }
    }
}