package main;

import main.Controller.InputController;
import main.Controller.OutputController;

import java.io.IOException;

public class LadderGameManager {
    private LadderGame ladderGame;

    public void init() {
        try {
            int playerNum = InputController.inputNumber("참여할 사람은 몇 명인가요?");
            int ladderHeight = InputController.inputNumber("최대 사다리 높이는 몇 개인가요?");
            String[] playerNames = InputController.inputStringWithDelimiter("참여할 사람 이름(최대 5글자)을 입력하세요. (이름은 쉼표(,)로 구분하세요)", ",");
            ladderGame = new LadderGame(playerNum, ladderHeight, playerNames);
            InputController.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLadder() {
//        OutputController.showLadder(ladderGame.getLadderArr());
        ladderGame.printLadderGame();
    }

}
