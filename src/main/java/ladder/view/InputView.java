package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);
    public InputView() {
    }

    public void run() {

        Player player = new Player(inputPlayer());

        LadderGame ladderGame = new LadderGame(player.getPlayerCount(), getLadderHeight());

        sc.close();
    }

    private int getLadderHeight() {
        printLadderCountNotification();
        return sc.nextInt();
    }

    private static void printLadderCountNotification() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    private static List<String> inputPlayer() {
        printUserCountNotification();
        return new ArrayList<>(Arrays.asList(sc.nextLine().split("\\s*,\\s*")));
    }

    private static void printUserCountNotification() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }
}
