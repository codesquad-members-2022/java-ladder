package com.ttasjwi.LadderGame;

import com.ttasjwi.LadderGame.game.result.GameResultService;
import com.ttasjwi.LadderGame.game.init.GameInitializer;
import com.ttasjwi.LadderGame.game.init.LadderElement;
import com.ttasjwi.LadderGame.view.input.InputView;
import com.ttasjwi.LadderGame.view.output.OutputView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GameClient {

    private InputView inputView;
    private OutputView outputView;
    private GameInitializer gameInitializer;
    private GameResultService gameResultService;

    public GameClient() {
        init();
    }

    private void init() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        inputView = ac.getBean(InputView.class);
        outputView = ac.getBean(OutputView.class);
        gameInitializer = ac.getBean(GameInitializer.class);
        gameResultService = ac.getBean(GameResultService.class);
    }

    public void run() {
        initGame();
        LadderElement[][] ladder = gameResultService.getLadder();
        outputView.printLadder(ladder);
    }

    private void initGame() {
        int entry = inputView.inputEntry();
        int height = inputView.inputHeight();
        gameInitializer.initLadder(entry, height);
    }
}
