package src.ladder;

import java.util.List;

public class Game {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Ladder ladder;

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    private void play() {
        ladder = createLadder();
        outputView.printLadder(ladder);
    }

    private Ladder createLadder() {
        List<String> players = inputView.inputPlayers("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        int ladderHeight = inputView.inputNumber("최대 사다리 높이는 몇 개인가요?");
        return new Ladder(players, ladderHeight);
    }

}
