package baseball.domain;

public class Validator {
   public void userInput(String inputNumber) {
      if (inputNumber == null || inputNumber.isEmpty()) {
         throw new IllegalArgumentException("입력값이 null이거나 비어있을 수 없습니다.");
      }

      if (inputNumber.length() != 3) {
         throw new IllegalArgumentException("입력값은 세 자리 숫자여야 합니다.");
      }

      for (String number : inputNumber.split("")) {
         int digit = Integer.parseInt(number);
         if (digit < 1 || digit > 9) {
            throw new IllegalArgumentException("각 숫자는 1과 9 사이의 값이어야 합니다.");
         }
      }

      long distinctCount = inputNumber.chars().distinct().count();
      if (distinctCount != 3) {
         throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
      }
   }


   public void gameModeInput(String input) {
      if (!input.equals("1") && !input.equals("2")) {
         throw new IllegalArgumentException("게임 모드는 1(재시작) 또는 2(종료)이어야 합니다.");
      }
   }

}
