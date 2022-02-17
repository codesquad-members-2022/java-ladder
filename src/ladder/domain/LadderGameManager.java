package ladder.domain;

import ladder.view.InputView;

import java.io.IOException;

public class LadderGameManager {
    private static final int MAX_NAME_LENGTH = 5;

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
        int playerNum = InputView.inputPositiveNumber("참여할 사람은 몇 명인가요?");
        int ladderHeight = InputView.inputPositiveNumber("최대 사다리 높이는 몇 개인가요?");
        String[] playerNames = InputView.inputStringWithDelimiter("참여할 사람 이름(최대 5글자)을 입력하세요. (이름은 쉼표(,)로 구분하세요)", ",", MAX_NAME_LENGTH);
        ladderGame = new LadderGame(playerNum, ladderHeight, playerNames);
    }

    public void showLadder() {
        ladderGame.printLadderGame();
    }

}
