package baseball;

import baseball.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class Judge {
    private final Player player;
    private final List<Integer> computerNumber;
    private HashMap<Character, Integer> baseballScore;

    public Judge(){
        this.computerNumber = Computer.generateRandomNumber();
        this.player = new Player();
    }

    public void compare(){
        do{
            initBaseballScore();
            //플레이어 처리하고 결과 값 얻어서 결과값 가지고 다음 함수로 이동.
            List<Integer> playerNumber = player.makePlayerNumber();
            scoringResult(computerNumber, playerNumber);
        }while(continueGame());
    }


    //S, B, N 판단
    public void scoringResult(List<Integer> computerNumber, List<Integer> playerNumber){
        baseballScore.put('S', countStrike(computerNumber, playerNumber));
        baseballScore.put('B', countBall(computerNumber, playerNumber));
        printResult();
    }

    public int countStrike(List<Integer> computerNumber, List<Integer> playerNumber){
        int strikeNumber = 0;
        for(int i =0; i<computerNumber.size(); i++){
            if(computerNumber.get(i).equals(playerNumber.get(i))){
                strikeNumber++;
            }
        }
        return strikeNumber;
    }

    public int countBall(List<Integer> computerNumber, List<Integer> playerNumber){
        int ballNumber = 0;
        for(int i =0; i<computerNumber.size(); i++){
            if(computerNumber.contains(playerNumber.get(i)) && !computerNumber.get(i).equals(playerNumber.get(i))){
                ballNumber++;
            }
        }
        return ballNumber;
    }

    //해당 결과에 맞게 문자열 출력
    public void printResult(){
        int ballCount = baseballScore.get('B');
        int strikeCount = baseballScore.get('S');
        printBall(ballCount);
        printStrike(strikeCount);
        printNothing(ballCount, strikeCount);
    }

    public void printBall(int ballCount){
        if(ballCount != 0)
            OutputView.printBallMessage(ballCount);
    }

    public void printStrike(int strikeCount){
        if(strikeCount != 0)
            OutputView.printStrikeMessage(strikeCount);
    }

    public void printNothing(int ballCount, int strikeCount){
        if(ballCount==0 && strikeCount==0)
            OutputView.printNothingMessage(ballCount, strikeCount);
        else
            OutputView.printEmptyLine();
    }

    //해당 결과에 맞게 게임 다시 진행 or 게임 종료
    public boolean continueGame(){
        int strikeCount = baseballScore.get('S');
        if(strikeCount==3){
            OutputView.endGameMessage();
            return false;
        }
        return true;
    }

    public void initBaseballScore(){
        baseballScore = new HashMap<>(){{
            put('S', 0);
            put('B', 0);
        }};
    }
}
