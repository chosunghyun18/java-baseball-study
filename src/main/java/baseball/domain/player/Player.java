package baseball.domain.player;

import baseball.domain.ball.PlayerBall;
import baseball.domain.computer.Computer;
import baseball.validate.InputValidate;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Player extends GamePlayer {

    private Set<PlayerBall> balls;
    private final InputValidate inputValidate;
    private final InputView inputView;
    private int strikeCount;
    private int ballCount;

    private Player() {
        this.inputView = new InputView();
        this.inputValidate = new InputValidate();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private void initSettings() {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.balls = new LinkedHashSet<>();
    }

    public static Player readyPlayer() {
        return new Player();
    }

    @Override
    public Boolean checkFinishGame() {
        inputView.askGame();
        int given = InputValidate.singleNumberCheck(Console.readLine());
        return given == restartGameValue;
    }

    @Override
    public void fight(Computer computer) {
        boolean clear3Strike = false;
        while (!clear3Strike) {
            initSettings();
            inputView.infoInsertNumber();
            List<Integer> numbers = getGuessNumbers();
            savePlayerBalls(numbers);
            clear3Strike = swingResult(computer);
        }
    }

    private boolean swingResult(Computer computer) {
        incrementCountsBasedOnHits(computer);
        displayHintToUser(computer);
        return checkForGameEnd();
    }

    public void savePlayerBalls(List<Integer> numbers) {
        for (Integer number : numbers) {
            balls.add(new PlayerBall(number));
        }
    }

    public List<Integer> getGuessNumbers() {
        String givenInput = Console.readLine();
        return inputValidate.numbersCheck(givenInput);
    }

    private void incrementCountsBasedOnHits(Computer computer) {
        int playerBallOrder = 0;
        for (PlayerBall playerBall : balls) {
            int result = computer.processHint(playerBall, playerBallOrder);
            playerBallOrder++;
            processResult(result);
        }
    }

    private void processResult(int result) {
        if (result == strikeHit) {
            strikeCount++;
        } else if (result == ballHit) {
            ballCount++;
        }
    }

    private void displayHintToUser(Computer computer) {
        computer.showHint(strikeCount, ballCount);
    }

    private boolean checkForGameEnd() {
        if (strikeCount == maxNumberOfBallsAmount) {
            System.out.println(maxNumberOfBallsAmount + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
