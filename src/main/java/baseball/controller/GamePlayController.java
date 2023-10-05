package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.GameNumberCalculatorService;
import baseball.service.GameStatusService;
import baseball.view.GameResultView;
import baseball.view.GameStartView;
import baseball.view.InputNumbersView;
import baseball.view.SelectNextGameView;

import java.util.ArrayList;
import java.util.List;

public class GamePlayController {

    private static final int INDEX_STRIKE = 0;
    private static final int THREE_STRIKE = 3;
    private int gameStatusNumber;
    private List<Integer> userGameNumbers = new ArrayList<>();
    private List<Integer> computerGameNumbers = new ArrayList<>();
    private List<Integer> strikeAndBallCountList = new ArrayList<>();
    private final GameStatusService gameStatusService = new GameStatusService();
    private final GameNumberCalculatorService gameNumberCalculatorService = new GameNumberCalculatorService();
    private final GameResultView gameResultView = new GameResultView();
    private final InputNumbersView inputNumbersView = new InputNumbersView();
    private final SelectNextGameView selectNextGameView = new SelectNextGameView();
    private final GameStartView gameStartView = new GameStartView();
    private Computer computer = new Computer();
    private User user = new User();

    public void startGame() {
        gameStartView.printGameStart();
        computer.setComputerGameNumbers();

        while (!gameStatusService.isExitGame()) {
            inputUserNumber();
            setUserGameNumbers();
            setComputerGameNumbers();
            calculateStrikeAndBallCount();
            getGameResult();
        }
    }

    public void inputUserNumber() {
        user.setUserGameNumbers(inputNumbersView.getUserGameNumbers());
    }

    public void calculateStrikeAndBallCount() {
        strikeAndBallCountList = gameNumberCalculatorService.calculateGameNumber(userGameNumbers, computerGameNumbers);
    }

    public void getGameResult() {
        if (strikeAndBallCountList.get(INDEX_STRIKE) == THREE_STRIKE) {
            gameResultView.printThreeStrikeResult();
            inputNextGameNumber();
            gameStatusService.setNextGameStatus(gameStatusNumber, computer);
        }
        if (strikeAndBallCountList.get(INDEX_STRIKE) != THREE_STRIKE) {
            gameResultView.printNotThreeStrikeResult(strikeAndBallCountList);
        }
    }

    public void setUserGameNumbers() {
        userGameNumbers = user.getUserGameNumbers();
    }

    public void setComputerGameNumbers() {
        computerGameNumbers = computer.getComputerGameNumbers();
    }

    public void inputNextGameNumber() {
        gameStatusNumber = selectNextGameView.selectNextGame();
    }
}
