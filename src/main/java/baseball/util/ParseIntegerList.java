package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class ParseIntegerList {

    public static List<Integer> parseIntegerList(String numberTypeOfString) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < numberTypeOfString.length(); i++) {
            numList.add(numberTypeOfString.charAt(i) - '0');
        }
        return numList;
    }
}
