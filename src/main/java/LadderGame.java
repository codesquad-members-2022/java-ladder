import View.InputView;
import View.OutputView;
import domain.Ladder;
import domain.Names;

public class LadderGame {

    public void run() {
        Ladder ladder = InputView.askSettingLadder();
        InputView.close();
        OutputView.showLadder(ladder);
    }

}
