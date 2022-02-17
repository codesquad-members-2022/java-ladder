package main.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NUM_LADDER = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_OUTCOMES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String QUERY_PLAYER = "결과를 보고 싶은 사람은?";

    public static final String END_SIGNAL = "춘식이";
    public static final String QUERY_ALL = "all";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getNames() {
        OutputView.printMessage(INPUT_NAMES);
        return scanner.nextLine();
    }

    public static int getNumLadder() throws NumberFormatException {
        OutputView.printMessage(INPUT_NUM_LADDER);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getOutcomes() {
        OutputView.printMessage(INPUT_OUTCOMES);
        return scanner.nextLine();
    }
    public static String query() {
        OutputView.printMessage(QUERY_PLAYER);
        return scanner.nextLine();
    }

    public static void close() {
        scanner.close();
    }
}
