public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String[] playerNames = inputView.getPlayerNames();
        int playerCount = inputView.getPlayerCount();
        int height = inputView.getLadderHeight();

        Ladder ladder = new Ladder(height, playerCount);

        outputView.printLadder(ladder);

        inputView.close();
    }
}
