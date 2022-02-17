import domain.game.LadderGameService;
import domain.user.User;
import view.input.InputView;
import view.output.OutputView;

import java.util.List;

public class GameApplication {

    private AppConfig ac;
    private InputView inputView;
    private OutputView outputView;
    private LadderGameService ladderGameService;

    public GameApplication() {
        init();
    }

    private void init() {
        ac = AppConfig.getInstance();
        inputView = ac.inputView();
        outputView = ac.outputView();
        ladderGameService = ac.ladderGameService();
    }

    public void run() {
        initLadderGame();
        String resultMap = ladderGameService.getResultMap();
        outputView.printResultMap(resultMap);
        ac.close();
    }

    private void initLadderGame() {
        List<User> users = inputView.inputUsers();
        int height = inputView.inputHeight();
        ladderGameService.initLadderGame(users, height);
    }
}
