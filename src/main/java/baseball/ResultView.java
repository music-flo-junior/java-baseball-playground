package baseball;

import java.util.Scanner;

public class ResultView {
    public void printResultView(String resultMessage) {
        System.out.println(resultMessage);
    }

    public boolean printGameOverViewAndGetIsGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        String restartInput = sc.nextLine();

        while (!"1".equals(restartInput) && !"2".equals(restartInput)) {
            System.out.println("다시 입력해주세요");
            restartInput = sc.nextLine();
        }

        return !"1".equals(restartInput);
    }
}
