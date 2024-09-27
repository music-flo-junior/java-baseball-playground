package study;

import java.util.Objects;

public class BaseBallGameResult {
    private final int strike;

    private final int ball;

    private BaseBallGameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallGameResult that = (BaseBallGameResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

    public boolean isSameStrikeAndBall(int strike, int ball) {
        return this.strike == strike && this.ball == ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public static BaseBallGameResult getGameResult(BallGroup answer, BallGroup input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < input.getBalls().size(); i++) {
            Ball inputBall = input.getBalls().get(i);
            Ball answerBall = answer.getBalls().get(i);
            if (inputBall.getNumber() == answerBall.getNumber()) {
                strike++;
                continue;
            }
            if (answer.isContainNumber(inputBall.getNumber())) {
                ball++;
            }
        }
        return new BaseBallGameResult(strike, ball);
    }

}
