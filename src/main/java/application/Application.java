package application;

import application.domain.LadderGame;
import application.domain.ladder.Ladder;
import application.domain.player.Players;
import application.domain.result.Results;
import application.util.InputUtils;
import application.view.InputView;
import application.view.OutputView;

import static application.util.InputUtils.END_CMD;

public class Application {
    private final InputView iv;
    private final OutputView ov;

    private LadderGame ladderGame;

    public Application() {
        this.iv = InputView.getInstance();
        this.ov = OutputView.getInstance();
    }

    public void run() {
        initGame();
        startGame();
        endGame();
    }

    private void initGame() {
        Players players = new Players(InputUtils.getPlayers(iv.playerNames()));
        Results results = new Results(InputUtils.getResult(iv.resultValues()));
        Ladder ladder = new Ladder(iv.ladderHeight(), players.getTotalNum() - 1);
        ladderGame = new LadderGame(ladder, players, results);
    }

    private void startGame() {
        ladderGame.start();
        ov.printGame(ladderGame);

        String playerName;
        while (!(playerName = iv.playerName()).equals(END_CMD)) {
            ov.printResult(ladderGame.getResult(playerName));
        }
    }

    private void endGame() {
        iv.close();
    }
}
