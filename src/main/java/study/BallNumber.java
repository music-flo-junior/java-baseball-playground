package study;

import java.util.Objects;

public class BallNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final int number;

    public BallNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("숫자는 %d부터 %d까지 입력할 수 있습니다.", MIN_NUMBER, MAX_NUMBER));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
