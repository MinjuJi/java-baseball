package baseball.exception;

public class NextGamePlayException {

    private static final String REGEX_ONE_OR_TWO = "^[12]$";

    public void checkValidOfNextGameNumber(String gameStatusNumber) {
        isRightLength(gameStatusNumber);
        isRightNumber(gameStatusNumber);
    }

    public void isRightLength(String gamestatusNumber) {
        if (gamestatusNumber.length() != 1)
            throw new IllegalArgumentException("숫자 하나만 입력해주세요.");
    }

    public void isRightNumber(String gameStatusNumber) {
        if (!gameStatusNumber.matches(REGEX_ONE_OR_TWO))
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
    }
}
