package controller;

import domain.gameservice.GameService;
import view.InputView;
import view.OutputView;


public class GameController {

    public void run() {
        boolean status = true;
        String[] users = InputView.getUserNameInput();
        String[] results = InputView.getItemsInput();
        int lineHeight = InputView.getLadderSizeInput();

        GameService ladderGame = new GameService(lineHeight, users, results);

        OutputView.printUsers(ladderGame.getUsers());
        OutputView.printLadder(ladderGame.getLadder());
        OutputView.printItems(ladderGame.getItems());

        ladderGame.playGame();

        while (status) {
            String target = InputView.getResultTargetInput();
            status = handleTargetInput(target,ladderGame);
        }
    }

    public boolean handleTargetInput(String target, GameService ladderGame) {
        if (target.equals("춘식이")) {
            return false;
        } else if(target.equals("all")){
            OutputView.printAllResult(ladderGame.getResults());
            return true;
        }else{
            OutputView.printSingleResult(ladderGame.getSingleUserResult(target));
            return true;
        }
    }
}
