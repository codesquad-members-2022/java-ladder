package view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_PERSON_GUIDANCE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_SIZE_GUIDANCE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String INPUT_NAME_LENGTH_ERROR_MESSAGE = "이름은 최대 5글자 까지만 가능합니다.";
    private static Scanner scanner = new Scanner(System.in);

    public static String[] requestPerson() {
        System.out.println(INPUT_PERSON_GUIDANCE_MESSAGE);
        String[] names = scanner.nextLine().split(",");
        if(invalidNameLength(names)){
            throw new IllegalArgumentException(INPUT_NAME_LENGTH_ERROR_MESSAGE);
        }
        return names;
    }

    private static boolean invalidNameLength(String[] names) {
        return Arrays.stream(names).anyMatch(i -> i.length() > 5);
    }

    public static int requestHeight() {
        System.out.println(INPUT_LADDER_SIZE_GUIDANCE_MESSAGE);
        return scanner.nextInt();
    }
}
