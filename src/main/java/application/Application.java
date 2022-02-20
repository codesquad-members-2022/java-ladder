package application;

import application.domain.LadderGame;
import application.domain.ladder.Ladder;
import application.domain.player.Players;
import application.util.InputUtils;
import application.view.InputView;
import application.view.OutputView;

public class Application {
    private final InputView iv;
    private final OutputView ov;
    private LadderGame ladderGame;

    public Application() {
        this.iv = InputView.getInstance();
        this.ov = OutputView.getInstance();
    }

    public void run() {
        Players players = new Players(InputUtils.getPlayers(iv.playerNames()));
        int height = iv.ladderHeight();
        Ladder ladder = new Ladder(height, players.getTotalNum() - 1);
        ladderGame = new LadderGame(ladder, players);
        ov.printGame(ladderGame);
        iv.close();
    }
}
