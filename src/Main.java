
public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder();

        int player = ladder.inputInfo("참여할 사람은 몇명인가요?");
        int height = ladder.inputInfo("최대 사다리 높이는 몇 개인가요?");

        ladder.printLadder(ladder.ladderInfo(player, height));
    }
}
