package main;

import main.Controller.InputController;
import main.Controller.OutputController;

import java.io.IOException;

public class LadderGameManager {
    private Ladder ladder;

    public void init() {
        int playerNum = InputController.inputNumber("참여할 사람은 몇 명인가요?");
        int ladderHeight = InputController.inputNumber("최대 사다리 높이는 몇 개인가요?");
        try {
            InputController.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ladder = new Ladder(playerNum, ladderHeight);

    }

    public void showLadder() {
        OutputController.showLadder(ladder.getLadderArr());
    }
}
