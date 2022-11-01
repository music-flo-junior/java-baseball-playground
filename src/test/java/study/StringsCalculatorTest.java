package study;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class StringsCalculatorTest {
    private static final Pattern IS_ONLY_NUMBER = Pattern.compile("^[0-9]*?");

    private int stringsCalculate(String targetString) {

        String[] targets = targetString.split(" ");

        int result = Integer.parseInt(targets[0]);

        for (int i = 1; i <= targets.length - 2; i += 2) {
            //FIXME : else 를 쓰지 말라고 했는데.. 나는 써도 된다 생각??
            if (isNumber(targets[i])) {
                result = calculate(new CalculatorVo(Integer.parseInt(targets[i]), Integer.parseInt(targets[i + 2]), targets[i + 1]));
            } else {
                result = calculate(new CalculatorVo(result, Integer.parseInt(targets[i + 1]), targets[i]));
            }
        }
        return result;
    }

    private boolean isNumber(String target) {
        return IS_ONLY_NUMBER.matcher(target).matches();
    }

    private int calculate(CalculatorVo calculatorVo) {
        switch (calculatorVo.getOperation()) {
            case "+" -> {
                return calculatorVo.getFirst() + calculatorVo.getSecond();
            }
            case "-" -> {
                return calculatorVo.getFirst() - calculatorVo.getSecond();
            }
            case "*" -> {
                return calculatorVo.getFirst() * calculatorVo.getSecond();
            }
            case "/" -> {
                return calculatorVo.getFirst() / calculatorVo.getSecond();
            }
            default -> {
            }
        }
        return 0;
    }

    @Test
    @DisplayName("문자열 계산하기")
    void stringsCalculate() {
        String actual = "2 + 3 * 4 / 2 * 30";
        assertThat(stringsCalculate(actual)).isEqualTo(300);
    }
}

@AllArgsConstructor
@Getter
class CalculatorVo {
    int first;
    int second;
    String operation;
}