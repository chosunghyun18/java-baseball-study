package baseball;

import camp.nextstep.edu.missionutils.Console;

import static util.Message.RESTART_MESSAGE;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do{
            Game game = new Game();
            game.startGame();
        }while(againGame());
    }

    //사용자에게 입력 받아서 게임 다시 시작 또는 종료
    private static boolean againGame() {
        //사용자에게 입력 받음
        System.out.println(RESTART_MESSAGE);
        String retryGameInput = Console.readLine();

        RetryGame retryGame = new RetryGame(retryGameInput);
        return retryGame.validateInput();
    }
}
