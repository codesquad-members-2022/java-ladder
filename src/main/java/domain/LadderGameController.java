package domain;

import java.util.ArrayList;

import view.InputView;

public class LadderGameController {
    public static void gameStart() {
        String nameList = InputView.inputPeopleName();
        int ladderHeight = InputView.inputLadderHeight();
        LadderGame ladderGame = new LadderGame(nameList, ladderHeight, new ArrayList<>());
        ladderGame.start();
        InputView.close();
    }
}
