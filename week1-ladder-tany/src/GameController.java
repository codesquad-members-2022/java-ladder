public class GameController {
    private Ladder ladder;

    public void runLadderGame() {
        LadderData ladderData = new LadderData();
        UserData userData = new UserData();
        OutputLadderMap outputLadderMap = new OutputLadderMap();

        ladderData.inputLadderData();
        userData.inputUserData();

        ladder = new Ladder(ladderData, userData);

        // TODO Ladder 객체 생성자를 호출했기 때문에 사다리를 초기화해 줄 차례
        ladder.initLadder();
        outputLadderMap.printLadder(ladder.getLadderMap());
    }
}
