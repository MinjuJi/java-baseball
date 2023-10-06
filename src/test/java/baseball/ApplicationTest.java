package baseball;

import baseball.domain.Computer;
import baseball.exception.NextGamePlayException;
import baseball.service.GameNumberCalculatorService;
import baseball.view.GameResultView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 입력_값_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_값_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("212"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_값_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("일이삼"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 상대방_번호_생성_길이_테스트() {
        // given
        final int NUMBER_LENGTH = 3;
        Computer computer = new Computer();

        // when
        computer.setComputerGameNumbers();

        // then
        assertThat(computer.getComputerGameNumbers().size()).isEqualTo(NUMBER_LENGTH);
    }

    @Test
    void 스트라이크_테스트() {
        // given
        final int INDEX_STRIKE = 0;
        final int THREE_STRIKE = 3;
        List<Integer> userGameNumbers = List.of(1, 2, 3);
        List<Integer> ComputerGameNumbers = List.of(1, 2, 3);
        GameNumberCalculatorService gameNumberCalculatorService = new GameNumberCalculatorService();

        // when
        List<Integer> strikeAndBallCountList = gameNumberCalculatorService.calculateGameNumber(userGameNumbers, ComputerGameNumbers);

        // then
        assertThat(strikeAndBallCountList.get(INDEX_STRIKE)).isEqualTo(THREE_STRIKE);
    }

    @Test
    void 볼_테스트() {
        // given
        final int INDEX_BALL = 1;
        final int THREE_BALL = 2;
        List<Integer> userGameNumbers = List.of(1, 2, 3);
        List<Integer> ComputerGameNumbers = List.of(2, 1, 3);
        GameNumberCalculatorService gameNumberCalculatorService = new GameNumberCalculatorService();

        // when
        List<Integer> strikeAndBallCountList = gameNumberCalculatorService.calculateGameNumber(userGameNumbers, ComputerGameNumbers);

        // then
        assertThat(strikeAndBallCountList.get(INDEX_BALL)).isEqualTo(THREE_BALL);
    }

    @Test
    void 낫싱_테스트() {
        // given
        List<Integer> strikeAndBallCount = List.of(0, 0);
        GameResultView gameResultView = new GameResultView();

        // ByteArrayOutputStream 클래스의 객체를 생성()
        OutputStream result = new ByteArrayOutputStream();

        // 표준 출력을 result 스트림으로 리디렉션. 즉 콘솔에 출력되는 내용을 result 스트림에 출력(저장)
        System.setOut(new PrintStream(result));

        // when
        gameResultView.printNotThreeStrikeResult(strikeAndBallCount); // "낫싱" 출력

        // then
        assertThat(result.toString().strip()).isEqualTo("낫싱");
        // result.toString().strip()는 result 스트림에 저장된 내용을 문자열로 변환하고 앞뒤 공백을 제거
        // strip() 메소드 필수! 없으면 테스트 실패
    }

    @Test
    void 게임종료_후_입력_값_숫자_예외_테스트() {
        // given
        String gameStatusNumber = "3";
        NextGamePlayException nextGamePlayException = new NextGamePlayException();

        //when, then
        assertThatThrownBy(() -> nextGamePlayException.isRightNumber(gameStatusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임종료_후_입력_값_범위_예외_테스트() {
        // given
        String gameStatusNumber = "12";
        NextGamePlayException nextGamePlayException = new NextGamePlayException();

        //when, then
        assertThatThrownBy(() -> nextGamePlayException.isRightLength(gameStatusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
