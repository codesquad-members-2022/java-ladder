
public class Main {

    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();

        int playerCount = input.ladderInfo("참여할 사람은 몇 명인가요?");
        int ladderHeight = input.ladderInfo("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(playerCount, ladderHeight);
        output.printLadder(ladder.makeLadder());

        input.close();
    }


}
