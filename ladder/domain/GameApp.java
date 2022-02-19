package ladder.domain;

import ladder.view.GameDisplay;
import ladder.view.UserInterface;

import java.util.List;

public class GameApp {

    public void run() {
        // 사용자 입력 받기(플레이어 이름, 사다리의 높이)
        UserInterface ui = new UserInterface();
        List<String> players = ui.inputPlayerList();
        int ladderHeight = ui.inputLadderHeight();

        // 사다리 정보 생성 및 출력
        LadderProcessor lp = new LadderProcessor();
        GameDisplay.showLadderGameInfo(players, lp.getLadderInfo(players.size(), ladderHeight));
    }

}
