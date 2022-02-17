package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Ladder ladder = InputView.createLadder();
        OutputView.printMap(ladder);
    }
}
