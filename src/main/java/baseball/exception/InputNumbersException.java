package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class InputNumbersException {
    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";
    private static final int REQUIRE_NUMBER_SIZE = 3;

    public void checkValidOfUserInput(String numberTypeOfString) {
        isNumberSizeEqualsThree(numberTypeOfString);
        isContainedOnlyNumber(numberTypeOfString);
        isOverlapNumber(numberTypeOfString);
    }

    public void isNumberSizeEqualsThree(String numberTypeOfString) {
        if (numberTypeOfString.length() != REQUIRE_NUMBER_SIZE)
            throw new IllegalArgumentException("3개의 수를 입력해주세요.");
    }

    public void isContainedOnlyNumber(String numberTypeOfString) {
        if (!isUserInputContainsOnlyNumber(numberTypeOfString))
            throw new IllegalArgumentException("1~9 숫자만 입력해주세요,");
    }

    public void isOverlapNumber(String numberTypeString) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < numberTypeString.length(); i++) {
            numSet.add(numberTypeString.charAt(i) - '0');
        }
        if (!isNumSetSizeEqualsPermittedSize(numSet))
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
    }

    public boolean isUserInputContainsOnlyNumber(String numberTypeOfString) {
        if (numberTypeOfString.matches(ONLY_NUMBER_REGEX))
            return true;
        return false;
    }

    public boolean isNumSetSizeEqualsPermittedSize(Set<Integer> numSet) {
        if (numSet.size() == REQUIRE_NUMBER_SIZE)
            return true;
        return false;
    }
}
