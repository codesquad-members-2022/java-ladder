package controller;

import domain.gameservice.GameService;
import view.InputUtil;
import view.OutputUtil;


public class GameController {

    public void run() {
        boolean status = true;
        String[] users = InputUtil.getUserNameInput();
        String[] results = InputUtil.getItemsInput();
        int lineHeight = InputUtil.getLadderSizeInput();

        GameService ladderGame = new GameService(lineHeight, users, results);

        OutputUtil.printUsers(ladderGame.getUsers());
        OutputUtil.printLadder(ladderGame.getLadder());
        OutputUtil.printItems(ladderGame.getItems());

        ladderGame.playGame();

        while (status) {
            String target = InputUtil.getResultTargetInput();
            status = handleTargetInput(target,ladderGame);
        }
    }

    public boolean handleTargetInput(String target, GameService ladderGame) {
        if (target.equals("춘식이")) {
            return false;
        } else if(target.equals("all")){
            OutputUtil.printAllResult(ladderGame.getResults());
            return true;
        }else{
            OutputUtil.printSingleResult(ladderGame.getSingleUserResult(target));
            return true;
        }
    }
}
