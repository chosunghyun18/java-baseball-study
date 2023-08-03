package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Baseball extends ConsoleGame {

  private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
  private static final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
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

  private boolean hasAllStrikes(int strikeCount) {
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
    StringBuilder result = new StringBuilder();
    if (ballCount > 0) {
      result.append(ballCount).append(BALL).append(" ");
    }
    if (strikeCount > 0) {
      result.append(strikeCount).append(STRIKE);
    }
    if (result.length() == 0) {
      result.append(NOTHING);
    }
    return result.toString().trim();
  }

  private List<Integer> convertInputToList(String userInput) {
    return userInput.chars()
        .mapToObj(Character::getNumericValue)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  private List<Integer> validateInput(List<Integer> user) {
    if (user.size() != NUMBER_LENGTH) {
      throw new IllegalArgumentException();
    }
    return user;
  }

  private List<Integer> generateUserIntList() {
    return
        validateInput(
            convertInputToList(
                ConsoleGame.getUserInput(GAME_INPUT_MESSAGE)));
  }

  private List<Integer> generateRandomIntList() {
    return IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
        .distinct()
        //.peek(System.out::println)
        .limit(NUMBER_LENGTH)
        .boxed()
        .collect(Collectors.toCollection(ArrayList::new));
  }

  private boolean guessAnswer() {
    List<Integer> guess = generateUserIntList();
    int ballCount = countBalls(guess);
    int strikeCount = countStrikes(guess);
    ConsoleGame.displayMessage(getResult(ballCount, strikeCount));
    return hasAllStrikes(strikeCount);
  }

  private Integer playSingleGame() {
    answer = generateRandomIntList();
    Stream.generate(this::guessAnswer)
        .takeWhile(Boolean.FALSE::equals)
        .forEach(e -> {
        });
    ConsoleGame.displayMessage(GAME_END_MESSAGE);
    try {
      return Integer.parseInt(ConsoleGame.getUserInput(GAME_OPTION_MESSAGE));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }
  }

  private void validateOption(Integer value) {
    if (!(value.equals(1) || value.equals(2))) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void playGame() {
    ConsoleGame.displayMessage(GAME_START_MESSAGE);
    Stream.generate(this::playSingleGame)
        .peek(this::validateOption)
        .takeWhile(Integer.valueOf(1)::equals)
        .forEach(e -> {
        });
  }
}
