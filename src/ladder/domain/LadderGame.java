package ladder.domain;

import ladder.view.*;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String[] playerNames = inputView.getPlayerNames();
        String[] rewards = inputView.getRewards();
        Players players = new Players(playerNames);

        int height = inputView.getLadderHeight();
        int playerCount = players.count();

        Ladder ladder = new Ladder(height, playerCount);

        outputView.printLayout(players, ladder);

        inputView.close();
    }
}
