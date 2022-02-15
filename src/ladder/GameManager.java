package src.ladder;

import java.io.IOException;

public class GameManager {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Ladder ladder;

    public void gameStart() {
        Ladder ladder = createLadder();
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
