
public class Main {

    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();

        String playerName = input.playerName("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        int ladderHeight = input.height("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(playerName, ladderHeight);

        output.printLadder(ladder.makeLadder(), ladder.setPlayerName(playerName));

        input.close();
    }
}
