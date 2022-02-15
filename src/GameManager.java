public class GameManager {

    public void StartGame(){
        InputItem inputItem = new InputItem();
        int userNum = inputItem.inputUserNumber();
        int ladderNum = inputItem.inputLadderNumber();

        Ladder ladder = new Ladder(userNum, ladderNum);
        ladder.print();
    }
}
