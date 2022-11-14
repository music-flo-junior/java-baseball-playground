package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {

    public static int[] createNoDuplicateRandomResultNumberArray(int baseballCount) {
        int[] resultNumberArray = new int[baseballCount];
        for (int i = 0; i < baseballCount; i++) {
            resultNumberArray[i] = createNoDuplicateNumber(resultNumberArray);
        }
        return resultNumberArray;
    }

    public static int createNoDuplicateNumber(int[] resultNumber) {
        int n = (int) (Math.random() * 9) + 1;

        while (resultNumber[0] == n || resultNumber[1] == n) {
            n = (int) (Math.random() * 9);
        }
        return n;
    }

    public static List<Integer> intToArrayList(int scanNumber, int baseballCount) {
        List<Integer> numberArray = new ArrayList<>(baseballCount);
        for (int i = 0; i < baseballCount; i++) {
            numberArray.add((int) (scanNumber / Math.pow(10, baseballCount - 1 - i)) % 10);
        }
        return numberArray;
    }
}
