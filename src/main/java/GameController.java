public class GameController {
    public static void run() {
        int playerCount = InputView.getInputNumer("참여할 사람은 몇 명인가요?");
        int ladderMaxHeight = InputView.getInputNumer("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = Ladder.create(playerCount, ladderMaxHeight);
        ladder.drawRandomLines();

        OutputView.print(ladder.getLines());
        InputView.close();
    }

    public static void main(String[] args) {
        GameController.run();
    }
}
