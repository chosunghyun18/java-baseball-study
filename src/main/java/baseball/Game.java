package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public abstract class Game {
    List<Integer> computerValue;
    String result;

    public Game(List<Integer> computerValue) {
        this.computerValue = computerValue;
    }

    public void gameStart() {
        System.out.println("게임을 시작합니다.");
        System.out.println(computerValue);
        inputNum();
    }

    public void inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        String[] splitInput = input.split("");
        Integer[] inputArray = new Integer[3];

        for (int i = 0; i < 3; i++) {
            inputArray[i] = Integer.parseInt(splitInput[i]);
        }

        strikeCheck(inputArray);
        ballCheck(inputArray);
        nothingCheck(inputArray);
        gameEnd();
    }

    public String ballCheck(Integer[] inputArray) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (computerValue.contains(inputArray[i])) {
                cnt++;
            }
        }

        if (cnt != 0) {
            result = cnt + "볼 ";
            return result;
        }
        return null;
    }

    public String strikeCheck(Integer[] inputArray) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (inputArray[i] == computerValue.get(i)) {
                cnt++;
            }
        }

        if (cnt == 3) {
            result = "3스트라이크";
            return result;
        }

        if (cnt != 0) {
            result += cnt + "스트라이크";
            return result;
        }

        return result;
    }

    public String nothingCheck(Integer[] inputArray) {
        if (result == null) {
            result = "낫싱";
        }
        return result;
    }

    public void gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String reGame = Console.readLine();

        if (reGame.equals("1")) {
            gameStart();
        }
    }
}