package main;

import main.Controller.InputController;
import main.Controller.OutputController;

public class LadderGameManager {
    private Ladder ladder;

    public void init() {
        int[] inputs = InputController.inputNumber();
        ladder = new Ladder(inputs[0], inputs[1]);
    }

    public void showLadder() {
        OutputController.showLadder(ladder.getLadderArr());
    }
}
