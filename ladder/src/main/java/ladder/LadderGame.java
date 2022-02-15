package ladder;

public class LadderGame {
    public void run() {
        inputValue();
    }

    private void inputValue() {
        Input input = new Input();
        Screen screen = new Screen();

        int userCount = screen.printUserCountBar(input);
        int ladderMaxHigh = screen.printLadderMaxHighBar(input);

        createLadder(userCount, ladderMaxHigh);
        input.close();
    }

    private void createLadder(int userCount, int ladderHigh) {
        Ladder ladder = new Ladder(userCount, ladderHigh);

    }
}
