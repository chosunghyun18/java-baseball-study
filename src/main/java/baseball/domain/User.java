package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Constant.INPUT_NUMBER;

public class User extends Player{
   public User() {
      this.validator = new Validator();
   }

   @Override
   public List<Integer> getNumber() {
      System.out.print(INPUT_NUMBER);
      String inputNumber = Console.readLine();
      // 입력 검사
      validator.userInput(inputNumber);
      List<Integer> user = new ArrayList<>();
      for (String number : inputNumber.split("")) {
         user.add(Integer.parseInt(number));
      }
      return user;
   }
}


