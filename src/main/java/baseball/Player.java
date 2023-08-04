package baseball;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static baseball.util.Message.OVER_THREE_NUMBER;
import static baseball.validateInput.*;

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
        InputView.getPlayerInput();
        playerInput = Console.readLine();

        return inputLength(playerInput) && inputIntegerCheck(playerInput) && inputIntegerRange(playerInput) && inputOverlapped(playerInput);
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