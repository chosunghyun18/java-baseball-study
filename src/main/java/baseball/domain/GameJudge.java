package baseball.domain;

import java.util.List;

import static baseball.constant.Constant.*;

public class GameJudge {
   private int strike;
   private int ball;

   public void countResult(List<Integer> computer, List<Integer> user) {
      strike = 0;
      ball = 0;
      for (int i = 0; i < LENGTH_OF_NUMBERS; i++) {
         if (computer.get(i).equals(user.get(i))) {
            strike++;
            continue;
         }
         if (computer.contains(user.get(i))) {
            ball++;
         }
      }
   }

   public void printResult() {
      String resultMsg = "";
      if (ball == 0 && strike == 0) {
         resultMsg = NOTHING;
      }
      if (ball > 0) {
         resultMsg += ball + BALL;
      }
      if (strike > 0) {
         resultMsg += strike + STRIKE;
      }
      System.out.println(resultMsg);
   }

   public boolean checkResult() {
      if (strike != LENGTH_OF_NUMBERS) {
         return false;
      }
      System.out.println(GAME_SUCCESS);
      return true;
   }
}
