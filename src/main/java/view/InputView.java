package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    private static final String PLAYERS_NAME_MESSAGES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하고 이름은 최대 5글자까지 가능합니다)";
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static Scanner sc;

    public static List<String> getPlayersName() {
        String playerNames = "";

        do {
            System.out.println(PLAYERS_NAME_MESSAGES);
            playerNames = sc.nextLine();
        } while (!isNameMaxLengthFive(playerNames));

        return playersNameList(playerNames);
    }

    private static boolean isNameMaxLengthFive(String playerNames) {
        String[] splitName = playerNames.split(PLAYER_NAME_DELIMITER);

        int satisfiedNameCount = (int)Arrays.stream(splitName)
                .filter(name -> name.length() <= 5)
                .count();
        int allNameCount = splitName.length;

        return satisfiedNameCount == allNameCount;
    }

    private static List<String> playersNameList(String playersName) {
        return Arrays.stream(playersName.split(PLAYER_NAME_DELIMITER))
                .collect(Collectors.toList());
    }

    public static int getMaxLadderHeight() {
        System.out.println(MAX_LADDER_HEIGHT_MESSAGE);
        return sc.nextInt();
    }

    public static void init() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
    }

    public static void close() {
        if (sc != null) {
            sc.close();
        }
    }
}
