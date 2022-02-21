package ladder.domain;

import ladder.view.GameDisplay;
import ladder.view.UserInterface;

import java.util.List;

public class GameApp {

    private static final String EXIT_WORD = "춘식이";
    private UserInterface userInterface;
    private LadderProcessor ladderProcessor;
    private GameResult gameResult;

    public GameApp() {
        userInterface = new UserInterface();
        ladderProcessor = new LadderProcessor();
    }

    public void run() {
        // 사용자 입력 받기(플레이어 이름, 결과, 사다리의 높이)
        List<String> players = userInterface.inputPlayerList();
        List<String> results = userInterface.inputExecutionResult();
        int ladderHeight = userInterface.inputLadderHeight();

        // 사다리 정보 가져오기 및 사다리 게임 화면 출력
        List<Line> ladderInfo = ladderProcessor.getLadderInfo(players.size(), ladderHeight);
        GameDisplay.showLadderGameInfo(players, ladderInfo, results);

        // 플레이어별 결과 가져오기 및 게임 결과 화면 출력
        gameResult = new GameResult(players, ladderInfo, results);
        while (true) informResult();
    }

    private void informResult() {
        String playerName = userInterface.inputPlayerNameForResult();
        if (playerName.equals(EXIT_WORD)) {
            GameDisplay.showGameExit();
            System.exit(130);
        }
        gameResult.getResult(playerName);
    }

}
