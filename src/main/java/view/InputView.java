package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String NAME_INPUT_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ITEM_INPUT_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_QUESTION = "최대 사다리 높이는 몇 개인가요?";
    private static final String TARGET_QUESTION = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER = ",";

    public List<String> inputUserName() {
        System.out.println(NAME_INPUT_QUESTION);

        String usernames = sc.nextLine();
        return Arrays.asList(usernames.split(DELIMITER));
    }

    public List<String> inputItems() {
        System.out.println(ITEM_INPUT_QUESTION);

        String resuls = sc.nextLine();
        return Arrays.asList(resuls.split(DELIMITER));
    }

    public int inputLadderSize() {
        System.out.println(HEIGHT_INPUT_QUESTION);
        return Integer.parseInt(sc.nextLine());
    }

    public String inputResultTarget() {
        System.out.println(TARGET_QUESTION);
        return sc.nextLine();
    }

    public void close() {
        sc.close();
    }
}
