package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String STRING_DELIMITER = ",";
    private static final String INPUT_PLAYER_NAMES = String.format(
            "참여할 사람 이름을 입력하십시오. 각 이름 사이에는 '%s'를 넣어 구분해주십시오.", STRING_DELIMITER);
    private static final String INPUT_LADDER_HEIGHT = "사다리의 높이를 입력하십시오.";

    private final Scanner sc = new Scanner(System.in);

    public String[] getPlayerNames() {
        return getLine(INPUT_PLAYER_NAMES).split(STRING_DELIMITER);
    }

    public int getLadderHeight() {
        return getInt(INPUT_LADDER_HEIGHT);
    }

    private int getInt(String message) {
        System.out.println(message);
        return Integer.parseInt(sc.nextLine());
    }

    private String getLine(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public void close() {
        sc.close();
    }
}
