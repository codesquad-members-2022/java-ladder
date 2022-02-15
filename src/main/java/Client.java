import view.InputView;
import view.PrintView;

public class Client {
    public static void main(String[] args) {
        PrintView.requestPeopleNumber();
        int peopleCount = InputView.inputPeopleNumber();
        PrintView.requestLadderHeight();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(peopleCount, ladderHeight);
        ladderGame.start();
    }
}
