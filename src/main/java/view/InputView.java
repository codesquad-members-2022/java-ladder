package view;

import java.util.Scanner;

public class InputView {

    private static final String PLAYERS_COUNT_MESSAGE = "참여할 사람은 몇 명인가요?";
    private static final String MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    private static Scanner sc;

    public static int getPlayersCount() {
        System.out.println(PLAYERS_COUNT_MESSAGE);
        return sc.nextInt();
    }

    public static int getMaxLadderHeight() {
        System.out.println(MAX_LADDER_HEIGHT_MESSAGE);
        return sc.nextInt();
    }

    public static void createScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
    }

    public static void closeScanner() {
        if (sc != null) {
            sc.close();
        }
    }
}
