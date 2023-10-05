package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateComputerGameNumbers {

    private static List<Integer> computerGameNumbers = new ArrayList<>();

    public static List<Integer> generateComputerGameNumbers() {
        computerGameNumbers.clear();
        while (computerGameNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerGameNumbers.contains(randomNumber)) {
                computerGameNumbers.add(randomNumber);
            }
        }
        return computerGameNumbers;
    }
}
