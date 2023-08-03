package baseball.view;

import static baseball.util.Message.*;

public class OutputView {
    public static void startGameMessage(){
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printBallMessage(int ballCount){
        System.out.print(ballCount+BALL);
    }

    public static void printStrikeMessage(int strikeCount){
        System.out.print(strikeCount+ STRIKE);
    }

    public static void printNothingMessage(int ballCount, int strikeCount){
        System.out.println(NOTHING);
    }

    public static void printEmptyLine(){
        System.out.println();
    }

    public static void endGameMessage(){
        System.out.println(END_GAME_MESSAGE);
    }

}
