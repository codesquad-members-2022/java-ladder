package ladder;

import ladder.model.GameManager;
import ladder.system.Configuration;

public class Main {
    public static void main(String[] args) throws Exception {
        GameManager gameManager = Configuration.gameManager;
        gameManager.startGame();

//        InputView inputView = new InputView();
//        OutputView outputView = new OutputView();
//        List<Integer> inputList = inputView.getWidthAndHeight();
//
//        int width = inputList.get(0);
//        int height = inputList.get(1);
//        LadderGame ladderGame = new LadderGame(new Board(width, height));
//        outputView.print(ladderGame.getResult());
    }
}
