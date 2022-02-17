package main;

import java.util.List;
import main.domain.LadderGame;
import main.util.InputUtil;
import main.view.InputView;
import main.view.OutputView;

public class GameController {

    public void run() {
        try {
            List<String> names = InputUtil.parseEntries(InputView.getNames());
            List<String> results = InputUtil.parseResults(InputView.getResults(), names.size());

            LadderGame game = new LadderGame(names, results, InputView.getNumLadder());
            OutputView.printGame(game);

        } catch (IllegalArgumentException e) {
            OutputView.printIllegalException();
        }

        InputView.close();
    }
}
