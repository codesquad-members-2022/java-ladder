package application;

import controller.LadderController;
import model.game.Game;
import model.game.ladder.Ladder;
import model.game.player.Player;
import util.Parser;
import util.GameUtil;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private final InputView iv;
    private final OutputView ov;
    private final LadderController ladderController;

    public Application() {
        this.iv = InputView.getInstance();
        this.ov = OutputView.getInstance();
        this.ladderController = LadderController.getInstance();
    }

    public void run() {
        List<Player> players = readPlayers();
        int height = readLadderHeight();
        Game game = ready(players, height);
        ov.printGame(game);
        iv.close();
    }
    private List<Player> readPlayers() {
        while (true) {
            try {
                return Parser.getPlayers(iv.playerNames());
            } catch (IllegalArgumentException e) {
                ov.printErrMsg(e.getMessage());
            }
        }
    }
    private int readLadderHeight() {
        return iv.ladderHeight();
    }
    private Game ready(List<Player> players, int height) {
        Ladder ladder = ladderController.getLadder(height, players.size(), GameUtil.getMaxPlayerName(players));
        return new Game(ladder, players);
    }
}
