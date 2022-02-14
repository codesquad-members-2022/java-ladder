import io.InputView;
import io.OutputView;

public class LadderGame {

    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private Ladder ladder;

    public void run() {
        initGame();
    }

    private void initGame() {
        // TODO: 입력 예외 처리
        int entry = Integer.parseInt(input.getEntry());
        int height = Integer.parseInt(input.getHeight());
        this.ladder = new Ladder(entry, height);
        output.print(ladder.toString());
    }
}
