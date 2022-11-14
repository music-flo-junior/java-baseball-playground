package baseball;

import baseball.model.Ball;
import baseball.model.Balls;
import baseball.model.PlayResult;
import baseball.type.BallStatusType;
import baseball.utils.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseballGame {

    private static final int BASEBALL_COUNT = 3;
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        numberBaseballGame.play();
    }

    public void play() {
        boolean isGameEnd;
        do {
            boolean isThreeStrike = false;

            List<Integer> resultNumberArray =
                    Arrays.stream(NumberUtils.createNoDuplicateRandomResultNumberArray(BASEBALL_COUNT)).boxed().collect(Collectors.toList());

            while (!isThreeStrike) {

                inputView.printInputView();

                List<Integer> inputNumberArray = NumberUtils.intToArrayList(inputView.scanNumber(), BASEBALL_COUNT);
                Balls answerBalls = new Balls(resultNumberArray);
                Balls userBalls = new Balls(inputNumberArray);

                PlayResult playResult = getPlayResult(answerBalls, userBalls);

                resultView.printResultView(playResult.getPrintFinalResult());

                isThreeStrike = playResult.isThreeStrike();
            }
            isGameEnd = resultView.printGameOverViewAndGetIsGameEnd();
        } while (!isGameEnd);
    }

    public PlayResult getPlayResult(Balls answerBalls, Balls userBalls) {
        PlayResult result = new PlayResult();
        for (Ball userBall : userBalls.getBalls()) {
            result.report(getBallStatusTypeToCompare(answerBalls, userBall));
        }
        return result;
    }

    private BallStatusType getBallStatusTypeToCompare(Balls answerBalls, Ball userBall) {
        return answerBalls.getBalls().stream()
                .map(answerBall -> answerBall.compare(userBall))
                .filter(BallStatusType::isNotNothing)
                .findFirst()
                .orElse(BallStatusType.NOTHING);
    }
}
