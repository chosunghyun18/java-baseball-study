package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Start {
    public void start() {
        String end = "1";
        EndError enderr = new EndError();
        while(end.equals("1")) {
            Game G = new Game();
            G.play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            end = Console.readLine();
            enderr.err(end);
        }
    }
}
