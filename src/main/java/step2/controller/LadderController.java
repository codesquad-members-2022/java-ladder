package step2.controller;

import step2.service.GameService;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;
import java.util.Random;

public class LadderController {

    public void run() {
        List<Integer> playerArguments = InputView.requestInfo();
        GameService gameService = new GameService();
        char[][] ladder = gameService.makeLadder(playerArguments.get(0), playerArguments.get(1));
        OutputView.showLadder(ladder);
    }
}
