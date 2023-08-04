package baseball.domain;

import java.util.List;

public abstract class Player {
   protected Validator validator;
   public abstract List<Integer> getNumber();
}
