package controller;

import domain.service.GameService;
import view.InputUtil;
import view.OutputUtil;


public class GameController {

    public void run() {
        String[] users = InputUtil.getUserNameInput();
        String[] results = InputUtil.getResultsInput();
        int lineHeight = InputUtil.getLadderSizeInput();

        GameService ladderGame = new GameService(lineHeight, users, results);
//        OutputUtil.printLadder(ladderGame.getGameResult());
    }

}
