import view.InputView;
import view.PrintView;

public class Client {
    public static void main(String[] args) {
        int peopleCount = InputView.inputPeopleNumber();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(peopleCount, ladderHeight);
        ladderGame.start();
    }
}
