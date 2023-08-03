package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseball implements ConsoleGame {

  private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
  private static final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 :";
  private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
  private static final String GAME_OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
  private static final String NOTHING = "낫싱";
  private static final String BALL = "볼";
  private static final String STRIKE = "스트라이크";
  private static final int NUMBER_LENGTH = 3;
  private List<Integer> answer;
  static private Baseball instance;

  private Baseball() {
  }

  public static Baseball getInstance() {
    if (instance == null) {
      instance = new Baseball();
    }
    return instance;
  }

  private boolean isGameEnded(int strikeCount) {
    return strikeCount == NUMBER_LENGTH;
  }

  private int countBalls(List<Integer> input) {
    return (int) IntStream.range(0, NUMBER_LENGTH)
        .filter(i -> answer.contains(input.get(i)) && answer.indexOf(input.get(i)) != i)
        .count();
  }

  private int countStrikes(List<Integer> input) {
    return (int) IntStream.range(0, NUMBER_LENGTH)
        .filter(i -> Objects.equals(answer.get(i), input.get(i)))
        .count();
  }

  private String getResult(int ballCount, int strikeCount) {
    if (ballCount == 0 && strikeCount == 0) {
      return NOTHING;
    } else if (strikeCount == 0) {
      return ballCount + BALL;
    } else if (ballCount == 0) {
      return strikeCount + STRIKE;
    }
    return String.format("%d%s %d%s", ballCount, BALL, strikeCount, STRIKE);
  }

  private List<Integer> convertInputToList(String userInput) {
    return userInput.chars()
        .mapToObj(Character::getNumericValue)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  private List<Integer> validateInput(List<Integer> user) throws IllegalArgumentException {
    if (user.size() != NUMBER_LENGTH) {
      throw new IllegalArgumentException();
    }
    return user;
  }

  private List<Integer> generateUserIntList() throws IllegalArgumentException {
    return
        validateInput(
            convertInputToList(
                ConsoleGame.getUserInput(GAME_INPUT_MESSAGE)));
  }

  private List<Integer> generateRandomIntList() {
    return IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
        .distinct()
        .peek(System.out::println)
        .limit(3)
        .boxed()
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public void initGame() {
    answer = generateRandomIntList();
  }


  @Override
  public void playGame() throws IllegalArgumentException {
    ConsoleGame.displayMessage(GAME_START_MESSAGE);
    String result;
    do {
      initGame();
      int ballCount;
      int strikeCount = 0;
      while (!isGameEnded(strikeCount)) {
        List<Integer> guess = generateUserIntList();
        ballCount = countBalls(guess);
        strikeCount = countStrikes(guess);
        ConsoleGame.displayMessage(getResult(ballCount, strikeCount));
      }
      ConsoleGame.displayMessage(GAME_END_MESSAGE);
      result = ConsoleGame.getUserInput(GAME_OPTION_MESSAGE);
    } while (result.equals("1"));
    if (!result.equals("2")) {
      throw new IllegalArgumentException();
    }
  }
}
