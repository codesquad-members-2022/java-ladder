
public class Main {

    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        InputLadder inputLadder = new InputLadder();

        int playerCount = inputLadder.ladderInfo("참여할 사람은 몇명인가요?");
        int ladderHeight = inputLadder.ladderInfo("최대 사다리 높이는 몇개인가요?");

        ladder.printLadder(ladder.ladderInfo(playerCount, ladderHeight));
    }


}
