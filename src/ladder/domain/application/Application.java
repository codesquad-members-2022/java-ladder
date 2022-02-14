package ladder.domain.application;

import ladder.domain.controller.Controller;
import ladder.domain.model.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    private InputView iv;
    private OutputView ov;
    private Controller controller;

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
    }
}
