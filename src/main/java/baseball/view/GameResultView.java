package baseball.view;

import java.util.List;

public class GameResultView {

    private static final int INDEX_STRIKE = 0;
    private static final int INDEX_BALL = 1;

    public void printNotThreeStrikeResult(List<Integer> strikeAndBallCount) {
        int strikeCount = strikeAndBallCount.get(INDEX_STRIKE);
        int ballCount = strikeAndBallCount.get(INDEX_BALL);

        if (strikeCount == 0 && ballCount == 0)
            System.out.println("낫싱");
        if (strikeCount != 0 && ballCount != 0)
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        if (strikeCount == 0 && ballCount != 0)
            System.out.println(ballCount + "볼 ");
        if (strikeCount != 0 && ballCount == 0)
            System.out.println(strikeCount + "스트라이크");
    }

    public void printThreeStrikeResult() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
