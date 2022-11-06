package study;

import java.util.Objects;

public class Ball {
    private final BallNumber number;
    
    private final BallPosition position;

    public Ball(int position, int number) {
        this.number = new BallNumber(number);
        this.position = new BallPosition(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(number, ball.number) && Objects.equals(position, ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }

    public int getNumber() {
        return number.getNumber();
    }

    public int getPosition() {
        return position.getPosition();
    }

}
