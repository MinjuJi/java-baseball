package baseball.service;

import baseball.domain.Computer;

public class GameStatusService {
    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;
    private boolean exitGame;

    public boolean isExitGame() {
        return exitGame;
    }

    public void setNextGameStatus(int gameStatusNumber, Computer computer) {
        if (gameStatusNumber == RESTART_GAME) {
            computer.setComputerGameNumbers();
        }
        if (gameStatusNumber == END_GAME) {
            exitGame = true;
        }
    }
}
