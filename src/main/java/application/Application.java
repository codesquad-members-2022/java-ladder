package application;

import application.controller.LadderController;
import application.game.Game;
import application.domain.ladder.Ladder;
import application.domain.player.Player;
import application.util.Parser;
import application.util.GameUtils;
import application.view.InputView;
import application.view.OutputView;

import java.util.List;

import static application.message.GameMessage.RUNTIME_ERROR_MESSAGE;

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
        try {
            List<Player> players = readPlayers();
            int height = readLadderHeight();
            Game game = ready(players, height);
            ov.printGame(game);
        } catch (RuntimeException e) {
            ov.printErrMsg(RUNTIME_ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            iv.close();
        }
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
        Ladder ladder = ladderController.getLadder(height, players.size(), GameUtils.getMaxPlayerName(players));
        return new Game(ladder, players);
    }
}
