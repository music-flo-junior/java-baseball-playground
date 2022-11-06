package study;

import java.util.Objects;

public class BallPosition {

    private static final int MAX_POSITION = 2;
    private static final int MIN_POSITION = 0;
    private final int position;

    public BallPosition(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException(String.format("위치 값은 최소 %d부터 %d까지 가능합니다.", MIN_POSITION, MAX_POSITION));
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallPosition that = (BallPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
