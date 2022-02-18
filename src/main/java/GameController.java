import View.InputView;
import View.OutputView;
import domain.LadderGame;

public class GameController {

    private static final String QUIT_COMMAND = "춘식이";
    private static final String ALL_COMMNAD = "all";

    public void init() {
        LadderGame ladderGame = InputView.askSettingLadder();
        OutputView.showLadder(ladderGame);
        run(ladderGame);
        InputView.close();
        OutputView.closeGame();
    }

    private void run(LadderGame ladderGame) {
        String target;
        while (!(target = InputView.askPlayerForResult()).equals(QUIT_COMMAND)) {
            showResult(ladderGame, target);
        }
    }

    private void showResult(LadderGame ladderGame, String command) {
        if (command.equals(ALL_COMMNAD)) {
            OutputView.showAllResult(ladderGame);
            return;
        }
        try {
            OutputView.showTargetResult(ladderGame, command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run(ladderGame);
        }
    }

}
