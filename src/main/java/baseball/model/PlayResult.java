package baseball.model;

import baseball.type.BallStatusType;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatusType statusType) {
        if (statusType == BallStatusType.STRIKE) {
            this.strike += 1;
        }
        if (statusType == BallStatusType.BALL) {
            this.ball += 1;
        }
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public String getPrintFinalResult() {
        if (ball != 0 && strike != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball != 0) {
            return ball + "볼";
        }
        if (strike != 0) {
            return strike + "스트라이크";
        }
        return "낫싱";
    }
}