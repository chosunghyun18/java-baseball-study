package baseball.view;

import static baseball.util.Message.GET_PLAYER_INPUT;
import static baseball.util.Message.RESTART_MESSAGE;

public class InputView {
    public static void printRestartMessage(){
        System.out.println(RESTART_MESSAGE);
    }

    public static void getPlayerInput(){
        System.out.print(GET_PLAYER_INPUT);
    }
}
