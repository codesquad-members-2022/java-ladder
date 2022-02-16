package main.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NUM_LADDER = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getNames() {
        OutputView.printMessage(INPUT_NAMES);
        return scanner.nextLine();
    }

    public static int getNumLadder() {
        OutputView.printMessage(INPUT_NUM_LADDER);
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
