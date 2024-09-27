package study;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBallMaker {

    public static BallGroup initRandomBallGroup() {
        Random random = ThreadLocalRandom.current();
        Map<Integer, Boolean> numberMap = new HashMap<>(3);
        int[] randomNums = new int[3];
        for (int i = 0; i < randomNums.length; i++) {
            while (true) {
                int randomNum = random.nextInt(9) + 1;
                if (numberMap.containsKey(randomNum)) {
                    continue;
                }
                randomNums[i] = randomNum;
                numberMap.put(randomNums[i], true);
                break;
            }
        }
        return new BallGroup(randomNums);
    }
}
