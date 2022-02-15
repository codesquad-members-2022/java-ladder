package ladder;

import ladder.model.Board;
import ladder.model.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        List<Integer> inputList = inputView.getWidthAndHeight();

        int width = inputList.get(0);
        int height = inputList.get(1);
        LadderGame ladderGame = new LadderGame(new Board(width, height));
        outputView.print(ladderGame.getResult());
    }
}
