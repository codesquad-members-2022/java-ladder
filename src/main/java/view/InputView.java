package view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_PERSON_GUIDANCE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_SIZE_GUIDANCE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static Scanner scanner = new Scanner(System.in);

    public static String[] requestPerson() {
        System.out.println(INPUT_PERSON_GUIDANCE_MESSAGE);
        return scanner.nextLine().split(",");
    }

    public static int requestHeight() {
        System.out.println(INPUT_LADDER_SIZE_GUIDANCE_MESSAGE);
        return scanner.nextInt();
    }
}
