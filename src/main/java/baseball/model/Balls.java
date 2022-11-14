package baseball.model;

import baseball.type.BallStatusType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> ballsNoArray) {
        List<Ball> ballArray = new ArrayList<>();
        for (int i = 0; i < ballsNoArray.size(); i++) {
            ballArray.add(new Ball(i + 1, ballsNoArray.get(i)));
        }
        this.balls = ballArray;
    }

}
