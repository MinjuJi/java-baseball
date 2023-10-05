package baseball.domain;

import baseball.util.GenerateComputerGameNumbers;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerGameNumbers = new ArrayList<>();

    public List<Integer> getComputerGameNumbers() {
        return computerGameNumbers;
    }

    public void setComputerGameNumbers() {
        this.computerGameNumbers = GenerateComputerGameNumbers.generateComputerGameNumbers();
    }
}
