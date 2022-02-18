import View.InputView;
import View.OutputView;
import domain.Board;

public class Main {

    public static void main(String[] args) {

        GameController ladderGame = new GameController();
        ladderGame.run();
        ladderGame.showResult();
    }
}
