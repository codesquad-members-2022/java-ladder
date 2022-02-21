package ladder.domain;

import ladder.view.InputView;

import java.io.IOException;

public class LadderGameManager {
    public static final int MAX_NAME_LENGTH = 5;
    private static final String COUNT_OF_PLAYER_MESSAGE = "참여할 사람은 몇 명인가요?";
    private static final String HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PLAYER_NAMES_MESSAGE = "참여할 사람 이름(최대 5글자)을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String GET_RESULT_MESSAGE = "\n결과를 보고 싶은 사람은? (키워드 안내: [전체 출력: all, 종료: 춘식이])";
    private static final String END_MESSAGE = "\n게임을 종료합니다.";
    private static final String END_KEYWORD = "춘식이";

    private LadderGame ladderGame;

    public void init() {
        try {
            createGameWithInput();
            showLadder();
            showResult();
            InputView.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createGameWithInput() throws IOException {
        int countOfPlayer = InputView.inputPositiveNumber(COUNT_OF_PLAYER_MESSAGE);
        int height = InputView.inputPositiveNumber(HEIGHT_MESSAGE);
        String[] playerNames = InputView.inputStringWithDelimiter(PLAYER_NAMES_MESSAGE, ",", MAX_NAME_LENGTH);
        String[] results = InputView.inputStringWithDelimiter(INPUT_RESULT_MESSAGE, ",");
        ladderGame = new LadderGame(new LadderGameInfo(countOfPlayer, height, playerNames, results));
    }

    private void showLadder() throws IOException {
        ladderGame.print();
    }

    private void showResult() throws IOException {
        String name;
        while (!(name = InputView.inputRequestNameForResult(GET_RESULT_MESSAGE)).equals(END_KEYWORD)) {
            ladderGame.printResultMapByName(name);
        }
        System.out.println(END_MESSAGE);
    }
}
