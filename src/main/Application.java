package main;

import main.Controller.InputController;
import main.Controller.OutputController;

public class Application {
    public static void main(String[] args) {
        // 사다리 게임 어플리케이션 실행부
        int[] inputs = InputController.inputNumber();
        Ladder ladder = new Ladder(inputs[0], inputs[1]);
        OutputController.showLadder(ladder.getLadderArr());
    }
}
