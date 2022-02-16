package src.ladder;

public class Game {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Ladder ladder;

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    private void start() {
        ladder = createLadder();
        outputView.printLadder(ladder);
    }

    private Ladder createLadder() {
        outputView.printInputPeopleCountGuide();
        int peopleCount = inputView.inputNumber();

        outputView.printInputLadderHeightInputGuide();
        int ladderHeight = inputView.inputNumber();

        return new Ladder(peopleCount, ladderHeight);
    }

}
