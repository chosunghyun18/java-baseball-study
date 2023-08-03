package baseball;

import java.util.HashMap;
import java.util.List;

import static util.Message.*;

public class Judge {
    private final Computer computer;
    private final Player player;
    private HashMap<Character, Integer> baseballScore;

    public Judge(){
        this.computer = new Computer();
        this.player = new Player();
    }

    public void compare(){
        List<Integer> computerNumber = computer.generateRandomNumber();
        do{
            initBaseballScore();
            //TODO 플레이어 처리하고 결과 값 얻어서 결과값 가지고 다음 함수로 이동.
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
        printBall();
        printStrike();
        printNothing();
    }

    private void printBall() {
        if(baseballScore.get('B') != 0)
            System.out.print(baseballScore.get('B')+BALL);
    }

    private void printStrike() {
        if(baseballScore.get('S') != 0)
            System.out.print(baseballScore.get('S')+STRIKE);
    }

    private void printNothing() {
        if(baseballScore.get('S')==0 && baseballScore.get('B')==0)
            System.out.println(NOTHING);
        else
            System.out.println();
    }


    //해당 결과에 맞게 게임 다시 진행 or 게임 종료
    public boolean continueGame(){
        if(baseballScore.get('S')==3){
            System.out.println(END_GAME_MESSAGE);
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
