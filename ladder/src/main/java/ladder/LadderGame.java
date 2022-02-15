package ladder;

public class LadderGame {
    public void run() {
        inputValue();
    }

    private void inputValue() {
        Screen screen = new Screen();
        Input input = new Input();

        screen.printUserCountBar();
        int userCount = input.inputString();
        screen.printLadderMaxHighBar();
        int ladderMaxHigh = input.inputString();

        createLadder(userCount, ladderMaxHigh);
    }

    private void createLadder(int userCount, int ladderHigh) {
        Ladder ladder = new Ladder(userCount, ladderHigh);

    }
}
