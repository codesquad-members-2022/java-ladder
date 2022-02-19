package main;

import static main.view.InputView.END_SIGNAL;

import java.util.List;
import main.domain.LadderGame;
import main.domain.Player;
import main.util.InputUtil;
import main.view.InputView;
import main.view.OutputView;

public class GameController {

    public void execute() {
        try {
            runGame();
        } catch (NumberFormatException e) {
            OutputView.printNumberException();
        } catch (IllegalArgumentException e) {
            OutputView.printIllegalException();
        }
        InputView.close();
    }

    private LadderGame createGame() {
        List<Player> players = InputUtil.parsePlayers(InputView.getNames());
        List<String> outcomes = InputUtil.parseOutcomes(InputView.getOutcomes(), players.size());
        return new LadderGame(players, outcomes, InputView.getNumLadder());
    }

    private void runGame() {
        LadderGame game = createGame();
        game.movePlayers();

        OutputView.printGame(game);
        query(game);
    }

    private void query(LadderGame game) {
        String line;

        while (!(line = InputView.query()).equals(END_SIGNAL)) {
            OutputView.printPlayers(game.queryPlayers(line));
        }
        OutputView.printEnd();
    }
}
