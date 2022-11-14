package baseball;

import baseball.model.Balls;
import baseball.model.PlayResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Mock
    NumberBaseballGame numberBaseballGame;

    @BeforeEach
    public void setUp() {
        numberBaseballGame = new NumberBaseballGame();
    }


    @Test
    @DisplayName("야구게임 볼 건 수 구하기 테스트")
    void ball() {
        Balls answerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        assertThat(numberBaseballGame.getPlayResult(answerBalls, userBalls).getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("야구게임 스트라이크 건 수 구하기 테스트")
    void strike() {
        Balls answerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        assertThat(numberBaseballGame.getPlayResult(answerBalls, userBalls).getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("야구게임 나싱 건 수 구하기 테스트")
    void nothing() {
        Balls answerBalls = new Balls(Arrays.asList(5, 5, 5));
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        assertThat(numberBaseballGame.getPlayResult(answerBalls, userBalls).isNothing()).isEqualTo(true);
    }

    @Test
    @DisplayName("3 스트라이크 구하기")
    void isThreeStrike() {
        Balls answerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        PlayResult playResult = numberBaseballGame.getPlayResult(answerBalls, userBalls);
        assertThat(playResult.isThreeStrike()).isTrue();
    }
}
