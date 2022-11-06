package baseball;

import java.util.Scanner;

// FIXME :
//  - 와일드카드를 이용한 임포트는 불가 : static이든 아니든, 와일드카드(*)를 이용한 임포트는 사용하지 않는다.
//  --> 흠... 근데 실무에서 많이 쓰지 않나?
//  - 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
//  --> 최대한 작게에 동의하시남...? 흠.. 너무 쪼개도 별로..라고 생각!
//  - 패키지 분리하면 접근제어자를 private 으로 설정 못하는데 이건 어떻게 생각??
public class NumberBaseballGame {
    private static final int BASEBALL_COUNT = 3;

    public static void main(String[] args) {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        numberBaseballGame.play();
    }

    public void play() {
        int[] resultNumberArray = createNoDuplicateRandomResultNumberArray();
        boolean threeStrike = false;
        int[] inputNumberArray;

        while (!threeStrike) {
            printInputView();
            inputNumberArray = intToArray(scanNumber());
            String resultMessage = createBaseballGameResult(resultNumberArray, inputNumberArray);
            printResultView(createBaseballGameResult(resultNumberArray, inputNumberArray));
            threeStrike = isThreeStrike(resultMessage);
        }

        printGameOverView();
    }

    int[] createNoDuplicateRandomResultNumberArray() {
        int[] resultNumberArray = new int[BASEBALL_COUNT];
        for (int i = 0; i < BASEBALL_COUNT; i++) {
            resultNumberArray[i] = createNoDuplicateNumber(resultNumberArray);
        }
        return resultNumberArray;
    }

    private int createNoDuplicateNumber(int[] resultNumber) {
        int n = (int) (Math.random() * 9) + 1;

        while (resultNumber[0] == n || resultNumber[1] == n) {
            n = (int) (Math.random() * 9);
        }
        return n;
    }

    private void printInputView() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    int scanNumber() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 다른 값이 입력 되었습니다. 다시 입력해주세요");
            return scanNumber();
        }

        if (inputString.length() != 3) {
            System.out.println("본 게임은 3자리 숫자의 숫자 야구 게임입니다. 3자리만 입력해주세요");
            return scanNumber();
        }
        return inputNumber;
    }

    int[] intToArray(int threeNumber) {
        int[] array = new int[BASEBALL_COUNT];
        for (int i = 0; i < BASEBALL_COUNT; i++) {
            array[i] = (int) (threeNumber / Math.pow(10, BASEBALL_COUNT - 1 - i)) % 10;
        }

        return array;
    }

    String createBaseballGameResult(int[] resultNumberArray, int[] inputNumberArray) {
        int strikeCount = createStrikeCount(resultNumberArray, inputNumberArray);
        int ballCount = createBallCount(resultNumberArray, inputNumberArray);

        if (ballCount != 0 && strikeCount != 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
        if (ballCount != 0) {
            return ballCount + "볼";
        }
        if (strikeCount != 0) {
            return strikeCount + "스트라이크";
        }
        return "-";
    }

    int createStrikeCount(int[] resultNumberArray, int[] inputNumberArray) {
        int count = 0;
        for (int i = 0; i < BASEBALL_COUNT; i++) {
            if (isSameNumber(resultNumberArray[i], inputNumberArray[i])) {
                count++;
            }
        }
        return count;
    }

    int createBallCount(int[] resultNumberArray, int[] inputNumberArray) {
        int count = 0;
        for (int i = 0; i < BASEBALL_COUNT; i++) {
            if (containNumberNotSameIndex(resultNumberArray[i], inputNumberArray, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean containNumberNotSameIndex(int number, int[] array, int index) {
        // FIXME :: 이거 들여쓰기 2 아닌가? 어떻게 들여쓰기를 안하지??
        for (int i = 0; i < BASEBALL_COUNT; i++) {
            if (isContainNumberNotSameIndex(number, array, i, index)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameNumber(int number1, int number2) {
        return number1 == number2;
    }

    private boolean isContainNumberNotSameIndex(int number, int[] array, int i, int index) {
        return isSameNumber(number, array[i]) && i != index;
    }

    boolean isThreeStrike(String resultMessage) {
        return resultMessage.equals("3스트라이크");
    }

    private void printResultView(String resultMessage) {
        System.out.println(resultMessage);
    }

    private void printGameOverView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restart();
    }

    private void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        String restartYn = sc.nextLine();
        while (!restartYn.equals("1") && !restartYn.equals("2")) {
            System.out.println("다시 입력해주세요");
            restartYn = sc.nextLine();
        }

        if (restartYn.equals("1")) {
            play();
        }
    }
}
