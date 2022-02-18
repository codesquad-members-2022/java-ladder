import ladder.Ladder;
import view.InputView;
import view.OutputView;

public class Main {
    private static InputView input = new InputView();
    private static Ladder ladder = new Ladder();
    private static OutputView output = new OutputView();
    public static void main(String[] args) {
        playLadderGame();
    }

    private static void playLadderGame() {
        input.startGame();
        output.printNames(ladder.makeNameString());
        output.printLadder(ladder.makeLadder());
        input.close();
    }
}
