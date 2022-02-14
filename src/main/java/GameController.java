public class GameController {


    public static void main(String[] args) {
        GameController.run();
    }

    private static void run() {
        int playerCount = InputView.getPlayerCount();
        int ladderMaxHeight = InputView.getLadderMaxHeight();

        Ladder ladder = Ladder.create(playerCount, ladderMaxHeight);

        OutputView.print(ladder);
    }
}
