package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class ParseIntegerSet {
    public static Set<Integer> parseIntegerSet(String numTypeOfString) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < numTypeOfString.length(); i++) {
            numSet.add(numTypeOfString.charAt(i) - '0');
        }
        return numSet;
    }
}
