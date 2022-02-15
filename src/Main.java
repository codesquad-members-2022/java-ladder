
public class Main {

    public static void main(String[] args) {

        InputLadder inputLadder = new InputLadder();
        OutputLadder outputLadder = new OutputLadder();

        int playerCount = inputLadder.ladderInfo("참여할 사람은 몇명인가요?");
        int ladderHeight = inputLadder.ladderInfo("최대 사다리 높이는 몇개인가요?");

        Ladder ladder = new Ladder(playerCount, ladderHeight);
        outputLadder.printLadder(ladder.makeLadder());
    }


}
