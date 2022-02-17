import View.InputView;
import View.OutputView;
import domain.Board;

public class Main {

    public static void main(String[] args) {

        LadderGame ladderGame = new LadderGame();
        ladderGame.init();
        ladderGame.run();
        ladderGame.showResult();
    }
}