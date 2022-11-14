package baseball;

import baseball.utils.NumberUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumbersBaseballGameTest {

    private static final int BASEBALL_COUNT = 3;

    @Test
    @DisplayName("중복되지 않는 숫자 배열 생성 테스트")
    void createNoDuplicateRandomResultNumberArray() {
        for (int i = 0; i < 20; i++) {
            int[] randomNumber = NumberUtils.createNoDuplicateRandomResultNumberArray(BASEBALL_COUNT);
            assertThat(randomNumber[0] == randomNumber[1]).isFalse();
            assertThat(randomNumber[0] == randomNumber[2]).isFalse();
            assertThat(randomNumber[1] == randomNumber[2]).isFalse();
        }
    }
}
