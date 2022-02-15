import io.InputValidator;
import io.InputView;
import io.OutputView;

public class LadderGame {

    private final InputView input = new InputView();
    private final InputValidator validator = new InputValidator();
    private final OutputView output = new OutputView();

    private Ladder ladder;

    public void run() {
        initGame();
    }

    private void initGame() {
        int entry = getEntry();
        int height = getHeight();
        this.ladder = new Ladder(entry, height);
        output.print(ladder.toString());
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
}
