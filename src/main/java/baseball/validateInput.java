package baseball;

import java.util.HashSet;

import static baseball.util.Message.*;

public class validateInput {

    //문자열의 길이가 3이 맞는지
    public static boolean inputLength(String playerInput){
        return playerInput.length() ==3;
    }

    //정수가 맞는지 아닌지
    public static boolean inputIntegerCheck(String playerInput){
        try{
            Integer.parseInt(playerInput);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    //1-9 사이의 숫자 인지
    public static boolean inputIntegerRange(String playerInput){
        return playerInput.matches("[1-9]+");
    }

    //같은 숫자가 반복되지는 않는지
    public static boolean inputOverlapped(String playerInput){
        HashSet<Character> digitSet = new HashSet<>();
        for(int i=0; i<playerInput.length(); i++){
            char digit = playerInput.charAt(i);
            if(digitSet.contains(digit)){
                return false;
            }
            digitSet.add(digit);
        }
        return true;
    }

    //다시 시작 입력 유효 판단(1, 2)
    public static boolean retryGameValidateInput(String retryGameInput) throws IllegalArgumentException {
        if (retryGameInput.equals(RESTART_GAME_NUMBER))
            return true;
        else if (!retryGameInput.equals(END_GAME_NUMBER))
            throw new IllegalArgumentException(RESTART_MESSAGE_ERROR);
        return false;
    }
}
