package baseball.type;

public enum BallStatusType {
    STRIKE,
    BALL,
    NOTHING;

    public static boolean isNotNothing(BallStatusType ballStatusType) {
        return NOTHING != ballStatusType;
    }
}
