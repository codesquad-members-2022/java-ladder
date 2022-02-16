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
        List<Player> players = Parser.getPlayers(iv.playerNames());
        int height = iv.ladderHeight();
        Ladder ladder = ladderController.getLadder(height, players.size()
                , GameUtil.getMaxPlayerName(players));
        Game game = new Game(ladder, players);
        ov.printGame(game);
        iv.close();
    }
}
