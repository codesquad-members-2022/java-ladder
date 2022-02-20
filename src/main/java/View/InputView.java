package View;

import Util.Validation;
import domain.Ladder;
import domain.LadderGame;
import domain.Players;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_DELIMITER = ",";
    private static final String PLAYER_NAMES_COMMAND = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PLAYER_NAMES_RESTRICTIONS = "[플레이어의 이름은 알파벳,숫자만 가능, 플레이어의 수는 2명이상 10명이하로 가능합니다.]";
    private static final String LADDER_HEIGHT_COMMAND = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_VALUES_COMMAND = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String RESULT_PLAYER_COMMAND = "결과를 보고 싶은 사람은?";
    private static final Scanner scanner = new Scanner(System.in);


    public static LadderGame askSettingLadder() {
        Players players = askPlayers();
        String[] results = askResultValues();
        Validation.comparePlayersWithResults(players.countOfPlayers(), results.length);
        return new LadderGame(players, results, askLadderHeight());
    }

    public static String askPlayerForResult() {
        System.out.println(RESULT_PLAYER_COMMAND);
        return scanner.nextLine();
    }

    public static void close() {
        scanner.close();
    }

    private static Players askPlayers() {
        System.out.println(PLAYER_NAMES_COMMAND);
        System.out.println(PLAYER_NAMES_RESTRICTIONS);
        String input = scanner.nextLine().replaceAll(" ", "");
        String[] playerNames;
        try {
            Validation.checkInputNames(input);
            playerNames = input.split(INPUT_DELIMITER);
            Validation.checkPlayers(playerNames.length);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askPlayers();
        }
        return new Players(playerNames);
    }

    public static int askLadderHeight() {
        System.out.println(LADDER_HEIGHT_COMMAND);
        return Integer.parseInt(scanner.nextLine());
    }

    private static String[] askResultValues() {
        System.out.println(RESULT_VALUES_COMMAND);
        return scanner.nextLine().replaceAll(" ", "").split(INPUT_DELIMITER);
    }


}

