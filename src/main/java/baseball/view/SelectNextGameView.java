package baseball.view;

import baseball.exception.NextGamePlayException;
import camp.nextstep.edu.missionutils.Console;

public class SelectNextGameView {

    private String NextGameStatus;
    private NextGamePlayException nextGamePlayException = new NextGamePlayException();


    public int selectNextGame() {
        printNextGameStatus();
        setNextGameStatus();
        checkNextGameNumberException(NextGameStatus);
        return Integer.parseInt(NextGameStatus);
    }

    public void printNextGameStatus() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }

    public void setNextGameStatus() {
        NextGameStatus = Console.readLine();
    }

    public void checkNextGameNumberException(String gameStatusNumber) {
        nextGamePlayException.checkValidOfNextGameNumber(gameStatusNumber);
    }
}
