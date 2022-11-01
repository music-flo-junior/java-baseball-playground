package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumbersBaseballGameTest {

    @Mock
    NumberBaseballGame nbg;

    @BeforeEach
    public void setUp(){
        nbg = new NumberBaseballGame();
    }

    @Test
    @DisplayName("중복되지 않는 숫자 배열 생성 테스트")
    void createNoDuplicateRandomResultNumberArray() {
        for (int i = 0; i < 20; i++) {
            int[] randomNumber = nbg.createNoDuplicateRandomResultNumberArray();
            assertThat(randomNumber[0] == randomNumber[1]).isFalse();
            assertThat(randomNumber[0] == randomNumber[2]).isFalse();
            assertThat(randomNumber[1] == randomNumber[2]).isFalse();
        }
    }

    @Test
    @DisplayName("스트라이크 개수 구하기")
    void createStrikeCount() {
        int[] randomArr = {1, 2, 3};
        int[] inputArr = {1, 2, 3};
        assertThat(nbg.createStrikeCount(randomArr, inputArr)).isEqualTo(3);
        inputArr[0] = 5;
        assertThat(nbg.createStrikeCount(randomArr, inputArr)).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 개수 구하기")
    void createBallCount() {
        int[] randomArr = {1, 2, 3};
        int[] inputArr = {3, 1, 2};
        assertThat(nbg.createBallCount(randomArr, inputArr)).isEqualTo(3);
        int[] inputArr2 = {1, 2, 3};
        assertThat(nbg.createBallCount(randomArr, inputArr2)).isEqualTo(0);
    }

    @Test
    @DisplayName("야구 게임 결과 구하기")
    void createBaseballGameResult() {
        int[] randomArr = {1, 2, 3};

        assertThat(nbg.createBaseballGameResult(randomArr, new int[]{1, 2, 3})).isEqualTo("3스트라이크");
        assertThat(nbg.createBaseballGameResult(randomArr, new int[]{3, 1, 2})).isEqualTo("3볼");
        assertThat(nbg.createBaseballGameResult(randomArr, new int[]{5, 4, 6})).isEqualTo("-");
        assertThat(nbg.createBaseballGameResult(randomArr, new int[]{1, 3, 6})).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("3 스트라이크 구하기")
    void isThreeStrike() {
        assertThat(nbg.isThreeStrike("3스트라이크")).isTrue();
        assertThat(nbg.isThreeStrike("2ㅇ")).isFalse();
    }
}
