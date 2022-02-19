package ladder.domain;

import ladder.view.GameDisplay;
import ladder.view.UserInterface;

import java.util.List;

public class GameApp {

    private UserInterface userInterface;
    private LadderProcessor ladderProcessor;

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
    }

}
