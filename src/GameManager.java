
public class GameManager {

    InputItem inputItem = new InputItem();

    public void start() {
        UserManager userManager = new UserManager(inputItem.inputUserName());
        int ladderNum = inputItem.inputLadderNumber();
        Ladder ladder = new Ladder(userManager, ladderNum);
        ladder.print();
    }
}
