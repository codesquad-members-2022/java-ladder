package application;

import controller.Controller;
import model.Ladder;
import view.InputView;
import view.OutputView;

public class Application {
    private final InputView iv;
    private final OutputView ov;
    private final Controller controller;

    public Application() {
        this.iv = InputView.getInstance();
        this.ov = OutputView.getInstance();
        this.controller = Controller.getInstance();
    }

    public void run() {
        int width = iv.numOfPlayers();
        int height = iv.ladderHeight();
        Ladder ladder = controller.getLadder(height, width);
        ov.printLadder(ladder);
        iv.close();
    }
}
