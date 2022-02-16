package View;

import java.util.Scanner;

public class InputView {

    private static final String PLAYER_COUNT_COMMAND ="참여할 사람은 몇 명인가요?";
    private static final String LADDER_HEIGHT_COMMAND ="최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int askHowManyPlayers() {
        System.out.println(PLAYER_COUNT_COMMAND);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int askLadderHeight() {
        System.out.println(LADDER_HEIGHT_COMMAND);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void close() {
        scanner.close();
    }


}