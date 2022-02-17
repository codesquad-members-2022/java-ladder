import io.InputValidator;
import io.InputView;
import io.OutputView;

public class LadderGame {

    private final InputView input = new InputView();
    private final InputValidator validator = new InputValidator();
    private final OutputView output = new OutputView();

    private Ladder ladder;
    private PlayerList players;

    public void run() {
        initGame();
        showResult();
        terminate();
    }

    private void initGame() {
        initPlayers();
        initLadder();
    }

    private void initPlayers() {
        String[] names = getPlayerNames();
        try {
            this.players = PlayerList.of(names);
        } catch (IllegalArgumentException e) {
            output.print(e.getMessage());
            initPlayers();
        }
    }

    private void initLadder() {
        int width = players.count() * 2 - 1;
        int height = getHeight();
        this.ladder = new Ladder(width, height);
    }

    private String[] getPlayerNames() {
        try {
            return validator.names(input.getPlayerNames());
        } catch (IllegalArgumentException e) {
            output.print(e.getMessage());
            return getPlayerNames();
        }
    }

    private int getEntry() {
        try {
            return validator.positiveInteger(input.getEntry());
        } catch (IllegalArgumentException e) {
            output.print(e.getMessage());
            return getEntry();
        }
    }

    private int getHeight() {
        try {
            return validator.positiveInteger(input.getHeight());
        } catch (IllegalArgumentException e) {
            output.print(e.getMessage());
            return getEntry();
        }
    }

    private void showResult() {
        output.print(players.toString());
        output.print(ladder.toString());
    }

    private void terminate() {
        input.close();
    }
}
