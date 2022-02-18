package ladder.domain;

import ladder.view.*;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String[] playerNames = inputView.getPlayerNames();
        String[] rewards = inputView.getRewards();
        int height = inputView.getLadderHeight();

        Group playerGroup = new Group(playerNames);
        int playerCount = playerGroup.count();

        Group rewardGroup = new Group(rewards, playerCount);
        Ladder ladder = new Ladder(height, playerCount);

        outputView.printLayout(ladder, playerGroup, rewardGroup);

        inputView.close();
    }
}
