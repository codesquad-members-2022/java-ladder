import view.InputView;
import view.PrintView;

public class LadderGameController {
    public static void gameStart() {
        PrintView.requestPeopleName();
        String nameList = InputView.inputPeopleName();

        PrintView.requestLadderHeight();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(nameList, ladderHeight);
        ladderGame.start();
    }
}
