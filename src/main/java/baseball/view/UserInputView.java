package baseball.view;

import baseball.exception.InputNumbersException;
import baseball.util.StringNumToIntegerNumListParser;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputView {
    private List<Integer> userGameNumbers = new ArrayList<>();
    private InputNumbersException inputNumbersException = new InputNumbersException();

    public List<Integer> setUserGameNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numberTypeOfSting = Console.readLine();
        inputNumbersException.checkValidOfUserInput(numberTypeOfSting);
        userGameNumbers = StringNumToIntegerNumListParser.stringNumToIntegerNumListParser(numberTypeOfSting);
        return userGameNumbers;
    }
}
