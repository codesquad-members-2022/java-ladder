import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYER_COUNT = "참여할 인원 수를 입력하십시오.";
    private static final String INPUT_LADDER_HEIGHT = "사다리의 높이를 입력하십시오.";

    private final Scanner sc = new Scanner(System.in);

    public int getPlayerCount() {
        return getInt(INPUT_PLAYER_COUNT);
    }

    public int getLadderHeight() {
        return getInt(INPUT_LADDER_HEIGHT);
    }

    public int getInt(String message) {
        System.out.println(message);
        return Integer.parseInt(sc.nextLine());
    }

    public void close() {
        sc.close();
    }
}
