package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String STRING_DELIMITER = ",";
    private static final String INPUT_PLAYER_NAMES = String.format(
            "참여할 사람 이름을 입력하십시오. 각 이름 사이에는 '%s'를 넣어 구분해주십시오.", STRING_DELIMITER);
    private static final String INPUT_LADDER_HEIGHT = "사다리의 높이를 입력하십시오.";

    private final Scanner sc = new Scanner(System.in);

    public String[] getPlayerNames() {
        System.out.println(INPUT_PLAYER_NAMES);
        return sc.nextLine().split(STRING_DELIMITER);
    }

    public int getLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        return Integer.parseInt(sc.nextLine());
    }

    public void close() {
        sc.close();
    }
}
