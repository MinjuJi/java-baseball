package baseball.exception;

import baseball.util.ParseIntegerSet;

import java.util.Set;

public class InputNumbersException {

    private static final String REGEX_NUMBER = "^[1-9]*$";

    public void checkValidOfUserInput(String userInput) {
        isNumbersSizeEqualsThree(userInput);
        isContainedOnlyNumber(userInput);
        isOverlapNumber(userInput);
    }

    public void isNumbersSizeEqualsThree(String userInput) {
        if (userInput.length() != 3)
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");

    }

    public void isContainedOnlyNumber(String userInput) {
        if (!userInput.matches(REGEX_NUMBER))
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
    }

    public void isOverlapNumber(String userInput) {
        Set<Integer> numSet = ParseIntegerSet.parseIntegerSet(userInput);
        if (numSet.size() != userInput.length())
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
    }
}
