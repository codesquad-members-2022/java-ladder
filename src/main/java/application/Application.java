package application;

import controller.LadderController;
import model.game.ladder.Ladder;
import view.InputView;
import view.OutputView;

public class Application {
    private final InputView iv;
    private final OutputView ov;
    private final LadderController ladderController;

    public Application() {
        this.iv = InputView.getInstance();
        this.ov = OutputView.getInstance();
        this.ladderController = LadderController.getInstance();
    }

    public void run() {
        int width = iv.numOfPlayers();
        int height = iv.ladderHeight();
        Ladder ladder = ladderController.getLadder(height, width);
        ov.printLadder(ladder);
        iv.close();
    }
}
