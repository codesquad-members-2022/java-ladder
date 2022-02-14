package application;

import controller.LadderController;
import model.Ladder;
import view.InputView;
import view.OutputView;

public class Application {
    private InputView iv;
    private OutputView ov;
    private LadderController controller;

    public Application() {
        this.iv = InputView.getInstance();
        this.ov = OutputView.getInstance();
        this.controller = LadderController.getInstance();
    }

    public void run() {
        int width = iv.numOfPlayers();
        int height = iv.ladderHeight();
        Ladder ladder = controller.getLadder(height, width);
        ov.printLadder(ladder);
    }
}
