package baseball;

import java.util.Scanner;

public class InputView {

    public void printInputView() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public int scanNumber() {
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
}
