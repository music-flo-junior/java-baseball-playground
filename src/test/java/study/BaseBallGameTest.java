package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {
    
    @Test
    @DisplayName("숫자 야구 게임 - ball이 있는 경우")
    public void testCheckAnswer() {
        BallGroup answer = new BallGroup(new int[]{1, 2, 3});
        BaseBallGameResult result = BaseBallGameResult.getGameResult(answer, new BallGroup(new int[]{2, 1, 4}));
        Assertions.assertThat(result.isSameStrikeAndBall(0, 2)).isTrue();
    }


    @Test
    @DisplayName("숫자 야구 게임 - 모두 strike인 경우")
    public void testCheckAnswer2() {
        BallGroup answer = new BallGroup(new int[]{1, 2, 3});
        BaseBallGameResult result = BaseBallGameResult.getGameResult(answer, new BallGroup(new int[]{1, 2, 3}));
        Assertions.assertThat(result.isSameStrikeAndBall(3, 0)).isTrue();
    }

    @Test
    @DisplayName("숫자 야구 게임 - 모두 틀린 경우")
    public void testCheckAnswer3() {
        BallGroup answer = new BallGroup(new int[]{5, 2, 3});
        BaseBallGameResult result = BaseBallGameResult.getGameResult(answer, new BallGroup(new int[]{4, 1, 6}));
        Assertions.assertThat(result.isSameStrikeAndBall(0, 0)).isTrue();
    }

    @Test
    @DisplayName("숫자 야구 게임 - 일부 스트라이크인 경우")
    public void testCheckAnswer4() {
        BallGroup answer = new BallGroup(new int[]{2, 1, 3});
        BaseBallGameResult result = BaseBallGameResult.getGameResult(answer, new BallGroup(new int[]{4, 1, 6}));
        Assertions.assertThat(result.isSameStrikeAndBall(1, 0)).isTrue();
    }

}