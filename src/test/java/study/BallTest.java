package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @Test
    @DisplayName("생성한 볼 그룹이 원하는 값대로 만들어졌나 확인")
    void ballMakeTest() {
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(0, 1));
        balls.add(new Ball(1, 5));
        balls.add(new Ball(2, 6));

        BallGroup ballGroup = new BallGroup(new int[]{1, 5, 6});
        for (int i = 0; i < 3; i++)
            assertThat(ballGroup.getBalls().get(i)).isEqualTo(balls.get(i));
    }

    @Test
    @DisplayName("랜덤 볼이 잘 생성되었나 확인")
    void ballMakeRandomTest() {
        BallGroup ballGroup = RandomBallMaker.getInstance().initRandomBallGroup();
        assertThat(ballGroup.getBalls()).hasSize(3);
    }
}
