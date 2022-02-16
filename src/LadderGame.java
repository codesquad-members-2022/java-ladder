public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int playerCount = inputView.getInt(SystemMessage.UI_INPUT_PLAYER_COUNT.getMessage());
        int height = inputView.getInt(SystemMessage.UI_INPUT_LADDER_HEIGHT.getMessage());

        Ladder ladder = new Ladder(height, playerCount);

        outputView.printLadder(ladder);

        inputView.close();
    }
}
