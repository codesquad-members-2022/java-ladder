package view;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);
    private static final String COMMA = ",";

    public static int getNumber() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return sc.nextInt();
    }

    public static void Close() {
        sc.close();
    }

    public static String[] getPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine().split(COMMA);
    }

    public static String[] getResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return sc.nextLine().split(COMMA);
    }

    public static String pickPlayer() {
        sc = new Scanner(System.in);
        System.out.println("\n결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }
}