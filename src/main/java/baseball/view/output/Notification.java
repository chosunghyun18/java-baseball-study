package baseball.view.output;

public class Notification {
    private void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void gameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
