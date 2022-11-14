package baseball.model;

import baseball.type.BallStatusType;

public class Ball {
    private final int position;
    private final int ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }

    private boolean matchBallNoAndPosition(Ball userBall) {
        return this.ballNo == userBall.ballNo && this.position == userBall.position;
    }

    public BallStatusType compare(Ball userBall) {
        if (this.matchBallNoAndPosition(userBall)) {
            return BallStatusType.STRIKE;
        }
        if (this.matchBallNo(userBall.ballNo)) {
            return BallStatusType.BALL;
        }
        return BallStatusType.NOTHING;
    }
}
