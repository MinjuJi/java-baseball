package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class GameNumberCalculatorService {

    private static final int NUMBER_LENGTH = 3;
    private int strikeCount;
    private int ballCount;
    private List<Integer> strikeAndBallCountList = new ArrayList<>();

    public List<Integer> calculateGameNumber(List<Integer> userGameNumbers, List<Integer> computerGameNumbers) {
        resetCalculator();
        countBall(userGameNumbers, computerGameNumbers);
        countStrike(userGameNumbers, computerGameNumbers);
        setStrikeAndBallCountList();
        return strikeAndBallCountList;
    }

    public void setStrikeAndBallCountList() {
        strikeAndBallCountList.add(strikeCount);
        strikeAndBallCountList.add(ballCount);
    }

    public void countStrike(List<Integer> userGameNumbers, List<Integer> computerGameNumbers) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerGameNumbers.get(i) == userGameNumbers.get(i))
                strikeCount++;
        }
    }

    public void countBall(List<Integer> userGameNumbers, List<Integer> computerGameNumbers) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerGameNumbers.contains(userGameNumbers.get(i)) && computerGameNumbers.get(i) != userGameNumbers.get(i))
                ballCount++;
        }
    }

    public void resetCalculator() {
        strikeAndBallCountList.clear();
        strikeCount = 0;
        ballCount = 0;
    }
}
