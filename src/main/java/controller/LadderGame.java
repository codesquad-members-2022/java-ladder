package controller;

import domain.Ladder;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    private List<String> playerNameList;

    public void start() {
        Ladder ladder = init();
        OutputView.printLadder(ladder);
    }

    private Ladder init() {
        InputView.init();
        playerNameList = InputView.getPlayersName();
        int playersCount = playerNameList.size();
        int maxLadderHeight = InputView.getMaxLadderHeight();
        InputView.close();

        return Ladder.getLadder(playersCount, maxLadderHeight);
    }
}
