package baseball;

import java.util.HashSet;
import java.util.Set;

abstract class Err {
    public abstract boolean err(String s);
}

class NumError extends Err{
    @Override
    public boolean err(String s){
        Set<String> numset = new HashSet<>();
        numset.add(String.valueOf(s.charAt(0)));
        numset.add(String.valueOf(s.charAt(1)));
        numset.add(String.valueOf(s.charAt(2)));
        if (s.length() != 3 || !s.matches("[1-9]+") || numset.size() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return false;
    }
}

class EndError extends Err{
    @Override
    public boolean err(String s){
        if (!s.matches("[12]")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return false;
    }
}
