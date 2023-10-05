package baseball.view;

import baseball.exception.InputNumbersException;
import baseball.util.ParseIntegerList;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumbersView {

    private String userInput;
    private List<Integer> userGameNumbers = new ArrayList<>();
    private InputNumbersException inputNumbersException = new InputNumbersException();

    public List<Integer> getUserGameNumbers() {
        printInputNumbers();
        getUserInput();
        checkUserInputException(userInput);
        toIntegerList(userInput);
        return userGameNumbers;
    }

    public void printInputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");

    }

    public void getUserInput() {
        userInput = Console.readLine();
    }

    public void checkUserInputException(String userInput) {
        inputNumbersException.checkValidOfUserInput(userInput);
    }

    public void toIntegerList(String userInput) {
        userGameNumbers = ParseIntegerList.parseIntegerList(userInput);
    }
}
