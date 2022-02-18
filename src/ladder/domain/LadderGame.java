package ladder.domain;

import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static final String END_OF_PROGRAM_SIGNAL = "춘식이";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Group playerGroup;
    private Group rewardGroup;
    private Ladder ladder;

    public void run() {
        String[] playerNames = inputView.getPlayerNames();
        String[] rewards = inputView.getRewards();
        int height = inputView.getLadderHeight();

        playerGroup = new Group(playerNames);
        int playerCount = playerGroup.count();

        rewardGroup = new Group(rewards, playerCount);
        ladder = new Ladder(height, playerCount);

        outputView.printLayout(ladder, playerGroup, rewardGroup);
        resultLoop();

        inputView.close();
    }

    private void resultLoop() {
        String name = "";

        while (!name.equals(END_OF_PROGRAM_SIGNAL)) {
            name = inputView.getPlayerNameToShowResult();
            showResult(name);
        }

        outputView.printOutro(END_OF_PROGRAM_SIGNAL);
    }

    private void showResult(String name) {
        if (name.equals("all")) {
            showAllResults();
            return;
        }

        if (name.equals(END_OF_PROGRAM_SIGNAL) || !(playerGroup.containsName(name))) {
            return;
        }

        showSingleResult(name);
    }

    private void showAllResults() {
        String allResult = IntStream.range(0, playerGroup.count())
                .mapToObj(this::buildResultRow)
                .collect(Collectors.joining());

        outputView.printAllResult(allResult);
    }

    private StringBuilder buildResultRow(int rowNumber) {
        return new StringBuilder().append(playerGroup.getName(rowNumber))
                .append(" : ")
                .append(rewardGroup.getName(ladder.getRewardIndex(rowNumber)))
                .append(System.lineSeparator());
    }

    private void showSingleResult(String name) {
        int playerIndex = playerGroup.getIndex(name);
        int rewardIndex = ladder.getRewardIndex(playerIndex);
        String reward = rewardGroup.getName(rewardIndex);

        outputView.printResult(reward);
    }
}
