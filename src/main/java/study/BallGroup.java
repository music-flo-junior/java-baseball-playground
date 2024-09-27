package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallGroup {
    public static final int MAX_CAPACITY = 3;
    private final List<Ball> balls;
    private Map<Integer, Boolean> ballMap;

    public BallGroup(int[] numbers) {
        if (numbers.length != MAX_CAPACITY) {
            throw new IllegalArgumentException(String.format("숫자는 총 %d개 입력되어야 합니다.", MAX_CAPACITY));
        }
        this.balls = new ArrayList<>(MAX_CAPACITY);
        for (int i = 0; i < numbers.length; i++) {
            balls.add(new Ball(i, numbers[i]));
        }
        initNumberMap(balls);
    }

    private void initNumberMap(List<Ball> balls) {
        Map<Integer, Boolean> numberMap = new HashMap<>();
        for (Ball ball : balls) {
            numberMap.put(ball.getNumber(), true);
        }
        if (balls.size() != numberMap.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        this.ballMap = numberMap;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public boolean isContainNumber(int number) {
        return this.ballMap.get(number) != null;
    }
}
