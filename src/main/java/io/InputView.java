package io;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String PROMPT = "> ";

    public String getEntry() {
        System.out.println("참여할 사람은 몇 명인가요?");
        System.out.print(PROMPT);
        return sc.nextLine();
    }

    public String getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        System.out.print(PROMPT);
        return sc.nextLine();
    }
}
