package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static util.Message.GET_PLAYER_INPUT;

public class Player {
    //입력을 받는다.
    public void getPlayerInput(){
        System.out.println(GET_PLAYER_INPUT);
        String playerInput = Console.readLine();


        //TODO 입력을 받아서 무엇을 할것인가...
        //TODO 플레이어 어떻게 처리할 것인가...

    }

    //문자열의 길이가 3이 맞는지
    public boolean inputLength(String playerInput){
        return playerInput.length() ==3;
    }

    //정수가 맞는지 아닌지
    public boolean inputIntegerCheck(String playerInput){
        try{
            Integer.parseInt(playerInput);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    //1-9 사이의 숫자 인지
    public boolean inputIntegerRange(String playerInput){
        return playerInput.matches("[1-9]+");
    }

    //같은 숫자가 반복되지는 않는지
    public boolean inputOverlapped(String playerInput){
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

    //입력이 유효하면 리스트로 만든다.
    public List<Integer> makePlayerNumber(String playerInput){
        List<Integer> playerNumber = new ArrayList<>();
        for(int i=0; i<playerInput.length(); i++){
            int number = Character.getNumericValue(playerInput.charAt(i));
            playerNumber.add(number);
        }
        return playerNumber;
    }

}