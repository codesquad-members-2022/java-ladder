package controller;

import domain.gameservice.GameService;
import view.InputView;
import view.OutputView;

import java.util.List;


public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void run() {
        boolean status = true;
        List<String> users = inputView.inputUserName();
        List<String> results = inputView.inputItems();
        int lineHeight = inputView.inputLadderSize();

        GameService ladderGame = new GameService(lineHeight, users, results);

        outputView.printUsers(ladderGame.getUsers());
        outputView.printLadder(ladderGame.getLadder());
        outputView.printItems(ladderGame.getItems());

        ladderGame.playGame();

        while (status) {
            String target = inputView.inputResultTarget();
            status = handleTargetInput(target, ladderGame);
        }
    }

    public boolean handleTargetInput(String target, GameService ladderGame) {
        if (target.equals("춘식이")) {
            return false;
        } else if (target.equals("all")) {
            outputView.printAllResult(ladderGame.getResults());
            return true;
        } else {
            outputView.printSingleResult(ladderGame.getSingleUserResult(target));
            return true;
        }
    }
}
