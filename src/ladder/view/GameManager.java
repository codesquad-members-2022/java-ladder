package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.UserManager;

public class GameManager {

    private InputItem inputItem = new InputItem();

    public void start() {
        UserManager userManager = new UserManager(inputItem.inputUserName());
        int ladderNum = inputItem.inputLadderNumber();
        Ladder ladder = new Ladder(userManager, ladderNum);
        ladder.print();
    }
}
