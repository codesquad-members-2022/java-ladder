package ladder;

public class LadderGame {
    public void run() {
        inputValue();
    }

    private void inputValue() {
        Input input = new Input();
        Output output = new Output();

        int userCount = output.printUserCountBar(input);
        int ladderMaxHigh = output.printLadderMaxHighBar(input);

        createLadder(userCount, ladderMaxHigh);
        input.close();
    }

    private void createLadder(int userCount, int ladderHigh) {
        Ladder ladder = new Ladder(userCount, ladderHigh);

    }
}
