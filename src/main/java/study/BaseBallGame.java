package study;

public class BaseBallGame {
    private BallGroup answer;

    public BaseBallGame() {
        this.answer = RandomBallMaker.initRandomBallGroup();
    }

    public void startGame() {
        while (true) {
            BallGroup inputs = InputView.takeInput();
            if (ResultView.isNotThreeStrike(BaseBallGameResult.getGameResult(answer, inputs))) {
                continue;
            }
            if (ResultView.isEndGame()) {
                break;
            }
            this.answer = RandomBallMaker.initRandomBallGroup();
        }
    }

}
