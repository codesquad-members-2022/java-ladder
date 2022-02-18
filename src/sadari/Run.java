package sadari;

import java.util.List;

public class Run {
    public void run() {
        InputView inputView = new InputView();

        List<String> playerNames = inputView.inputPlayers();
        int people = inputView.numberOfPlayers();
        int height = inputView.inputHeight();

        inputView.printNames();
        Ladder ladder = new Ladder(people, height);
        inputView.printLadder(ladder.makeLadder(height));
        inputView.close();
    }
}
