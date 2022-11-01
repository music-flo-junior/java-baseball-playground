package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] splitArrays = "1,2".split(",");
        assertThat(splitArrays).contains("1", "2");
        String[] oneSplitArrays = "1,".split(",");
        assertThat(oneSplitArrays).containsExactly("1");
    }

    @Test
    void subString() {
        String subString = "(1,2)".substring(1, 4);
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt Exception")
    void charAt() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    assertThat("abc".charAt(5)).isEqualTo(null);
                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}