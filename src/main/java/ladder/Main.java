package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {
        Ladder ladder = InputView.createLadder();
        OutputView.printLadderMap(ladder);
    }
}
