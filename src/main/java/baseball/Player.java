package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static util.Message.GET_PLAYER_INPUT;
import static util.Message.OVER_THREE_NUMBER;

public class Player {
    private String playerInput;
    public List<Integer> makePlayerNumber() throws IllegalArgumentException{
        if(getPlayerInput()){
            return transStringToList(playerInput);
        }
        else{
            throw new IllegalArgumentException(OVER_THREE_NUMBER);
        }
    }

    //입력을 받는다.
    public boolean getPlayerInput(){
        System.out.println(GET_PLAYER_INPUT);
        playerInput = Console.readLine();

        return inputLength(playerInput) && inputIntegerCheck(playerInput) && inputIntegerRange(playerInput) && inputOverlapped(playerInput);
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
    public List<Integer> transStringToList(String playerInput){
        List<Integer> playerNumber = new ArrayList<>();
        for(int i=0; i<playerInput.length(); i++){
            int number = Character.getNumericValue(playerInput.charAt(i));
            playerNumber.add(number);
        }
        return playerNumber;
    }

}