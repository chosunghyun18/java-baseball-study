package baseball;

import java.util.List;

public class Judge {
    private final Computer computer;
    private final Player player;

    public Judge(){
        this.computer = new Computer();
        this.player = new Player();
    }

    public void compare(){
        List<Integer> computerNumber = computer.generateRandomNumber();
        //TODO 플레이어 처리하고 결과 값 얻어서 결과값 가지고 다음 함수로 이동.
        //List<Integer> playerNumber = player.makePlayerNumber();

    }

    //S, B, N 판단
    public boolean scoringResult(List<Integer> computerNumber, List<Integer> playerNumber){

        return true;
    }


    //해당 결과에 맞게 문자열 출력
    public void printingResult(){

    }

    //해당 결과에 맞게 게임 다시 진행 or 게임 종료

//    while(!isPass()){
//
//    }
}
