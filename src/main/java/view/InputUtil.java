package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);

    public static String[] getUserNameInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String usernames = sc.nextLine();
        if(!validateUsernameFormat(usernames)){
            throw new InputMismatchException("참가자의 수가 부족합니다.");
        }
        return usernames.split(",");
    }

    public static int getLadderSizeInput() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public static void close() {
        sc.close();
    }


    public static boolean validateUsernameFormat(String usernames) {
        return usernames.split(",").length >= 2;
    }
}
