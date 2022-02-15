public class GameManager {

    public void StartGame(){
        InputItem inputItem = new InputItem();
        PrintItem printItem = new PrintItem();
        printItem.printLadder(inputItem.userNum, inputItem.ladderNum);
    }
}
