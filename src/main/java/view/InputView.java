package view;

import java.util.Scanner;

public class InputView {

    private static final String PLAYERS_COUNT_MESSAGE = "참여할 사람은 몇 명인가요?";
    private static final String MAX_LADDER_LENGTH_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    private static Scanner sc = new Scanner(System.in);

    public static String getPlayersCount() {
        System.out.println(PLAYERS_COUNT_MESSAGE);
        return sc.nextLine();
    }

    public static String getMaxLadderLength() {
        System.out.println(MAX_LADDER_LENGTH_MESSAGE);
        return sc.nextLine();
    }
}
