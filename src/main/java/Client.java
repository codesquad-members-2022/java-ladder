import view.InputView;

public class Client {
    public static void main(String[] args) {
        int peopleCount = InputView.inputPeopleNumber();
        int ladderHeight = InputView.inputLadderHeight();
        InputView.scannerClose();
        LadderGame ladderGame = new LadderGame(peopleCount, ladderHeight);
        ladderGame.start();
    }
}
