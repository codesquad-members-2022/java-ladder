public class GameManager {

    public void StartGame(){
        InputItem inputItem = new InputItem();
        PrintItem printItem = new PrintItem();
        int userNum = inputItem.inputUserNumber();
        int ladderNum = inputItem.inputLadderNumber();
        Ladder ladder = new Ladder(userNum, ladderNum);

        printItem.printLadder(ladder.userNum, ladder.ladderNum);
    }
}
