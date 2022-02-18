package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String STRING_DELIMITER = ",";
    private static final String INPUT_DELIMITED_ARGS = String.format(
            " (각 항목 사이에는 '%s'를 넣어 구분해주십시오.)", STRING_DELIMITER);
    private static final String INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하십시오.";
    private static final String INPUT_REWARDS = "결과 목록을 입력하십시오. 참여하는 사람 수를 초과하는 분량의 결과는 무시됩니다.";
    private static final String INPUT_LADDER_HEIGHT = "사다리의 높이를 입력하십시오.";

    private final Scanner sc = new Scanner(System.in);

    public String[] getPlayerNames() {
        return getStringArgs(INPUT_PLAYER_NAMES);
    }

    public String[] getRewards() {
        return getStringArgs(INPUT_REWARDS);
    }

    public int getLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        return Integer.parseInt(sc.nextLine());
    }

    private String[] getStringArgs(String message) {
        System.out.print(message);
        System.out.println(INPUT_DELIMITED_ARGS);
        return sc.nextLine().split(STRING_DELIMITER);
    }

    public void close() {
        sc.close();
    }
}
