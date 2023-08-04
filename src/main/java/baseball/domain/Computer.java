package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Constant.*;

public class Computer extends Player {

   @Override
   public List<Integer> getNumber() {
      List<Integer> computer = new ArrayList<>();
      while (computer.size() < 3) {
         int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
         if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
         }
      }
      return computer;
   }
}
