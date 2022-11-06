package study;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomBallMaker {
    private static RandomBallMaker instance = null;
    private final Random random = new Random();
    
    private RandomBallMaker() {
    }

    public static RandomBallMaker getInstance() {
        if (instance == null) {
            instance = new RandomBallMaker();
        }
        return instance;
    }

    public BallGroup initRandomBallGroup() {
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
