package view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_PERSON_GUIDANCE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_SIZE_GUIDANCE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String INPUT_NAME_LENGTH_ERROR_MESSAGE = "이름은 최대 5글자 까지만 가능합니다.";
    public static final String INPUT_LADDER_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    public static String[] requestPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_PERSON_GUIDANCE_MESSAGE);
        String[] names = scanner.nextLine().split(",");
        invalidNameLength(names);
        return names;
    }

    private static boolean invalidNameLength(String[] names) {
        boolean isMatch = Arrays.stream(names).anyMatch(i -> i.length() > 5);
        if(isMatch){
            throw new IllegalArgumentException(INPUT_NAME_LENGTH_ERROR_MESSAGE);
        }
        return isMatch;
    }

    public static String[] requestResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_LADDER_RESULT_MESSAGE);
        String[] results = scanner.nextLine().split(",");
        return results;
    }

    public static int requestHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_LADDER_SIZE_GUIDANCE_MESSAGE);
        return scanner.nextInt();
    }
}
