package Ladder.controller;

import Ladder.domain.Ladder;
import Ladder.view.InputView;
import Ladder.view.OutputView;

import java.util.List;

public class LadderGame {

    private List<String> playerNameList;

    public void start() {
        Ladder ladder = init();
        OutputView.printPlayersName(playerNameList);
        OutputView.printLadder(ladder);
    }

    private Ladder init() {
        InputView.init();
        playerNameList = InputView.getPlayersName();
        int playersCount = playerNameList.size();
        int maxLadderHeight = InputView.getMaxLadderHeight();
        InputView.close();

        return new Ladder(playersCount, maxLadderHeight);
    }
}
