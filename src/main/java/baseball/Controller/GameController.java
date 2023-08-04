package baseball.Controller;

import baseball.domain.*;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.Constant.*;

import java.util.List;

/*
 게임 세팅과 진행
 */
public class GameController {
    private final Player computer;
    private final Player user;
    private final GameJudge gameJudge;
    private final Validator validator;
    private boolean gameExit;

    public GameController() {
        this.computer = new Computer();
        this.user = new User();
        this.gameJudge = new GameJudge();
        this.validator = new Validator();
    }


    public void startGame() {
        // 게임 시작 메세지 출력
        System.out.println(GAME_START);
        while(!gameExit) {
            // 게임 실행
            playOneGame();
            // 게임 다시 시작할지말지 선택
            restartOrExit();
        }
    }

    private void restartOrExit() {
        System.out.println(GAME_SELECT);

        String input = Console.readLine();
        validator.gameModeInput(input);

        if (input.equals("1")) {
            gameExit = false;
        }

        if (input.equals("2")) {
            System.out.println(GAME_FINISH);
            gameExit = true;
        }
    }
    /**
     * 1. 컴퓨터 랜덤수 생성
     * 2. 사용자 입력
     * 3. 컴퓨터와 비교
     * 4. 결과 출력
     */
    public void playOneGame() {
        do {
            // 컴퓨터 입력
            List<Integer> computerNum = computer.getNumber();
            // 사용자 입력
            List<Integer> userNum = user.getNumber();
            gameJudge.countResult(computerNum, userNum);
            gameJudge.printResult();
        } while (!gameJudge.checkResult());
    }
}
