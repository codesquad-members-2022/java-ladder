package ladder.domain;

import ladder.view.InputView;

import java.io.IOException;

public class LadderGameManager {
    public static final int MAX_NAME_LENGTH = 5;
    private static final String COUNT_OF_PLAYER_MESSAGE = "참여할 사람은 몇 명인가요?";
    private static final String HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PLAYER_NAMES_MESSAGE = "참여할 사람 이름(최대 5글자)을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GET_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    private LadderGame ladderGame;

    public void init() {
        try {
            createGameWithInput();
            InputView.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createGameWithInput() throws IOException {
        int countOfPlayer = InputView.inputPositiveNumber(COUNT_OF_PLAYER_MESSAGE);
        int height = InputView.inputPositiveNumber(HEIGHT_MESSAGE);
        String[] playerNames = InputView.inputStringWithDelimiter(PLAYER_NAMES_MESSAGE, ",", MAX_NAME_LENGTH);
        String[] results = InputView.inputStringWithDelimiter(GET_RESULT_MESSAGE, ",");
        ladderGame = new LadderGame(new LadderGameInfo(countOfPlayer, height, playerNames, results));
    }

    public void showLadder() {
        ladderGame.printLadderGame();
    }

}
