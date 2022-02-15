import view.InputView;

public class LadderGameController {
    public static void gameStart() {
        String nameList = InputView.inputPeopleName();
        int ladderHeight = InputView.inputLadderHeight();
        LadderGame ladderGame = new LadderGame(nameList, ladderHeight);
        ladderGame.start();
        InputView.scannerClose();
    }
}
