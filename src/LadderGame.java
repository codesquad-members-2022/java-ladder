public class LadderGame {
    private final InputView inputView = new InputView();

    public void run() {
        int playerCount = inputView.getInt(SystemMessage.UI_INPUT_PLAYER_COUNT.getMessage());
        int height = inputView.getInt(SystemMessage.UI_INPUT_LADDER_HEIGHT.getMessage());
        System.out.println();

        Ladder ladder = new Ladder(height, playerCount);
        System.out.println(ladder.render());

        inputView.close();
    }
}
