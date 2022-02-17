package controller;

import domain.service.GameService;
import view.InputUtil;
import view.OutputUtil;


public class GameController {

    public void run() {
        String[] users = InputUtil.getUserNameInput();;
        int lineHeight = InputUtil.getLadderSizeInput();

        GameService ladderGame = new GameService(lineHeight, users);
        OutputUtil.printLadder(ladderGame.getGameResult());
    }

}
