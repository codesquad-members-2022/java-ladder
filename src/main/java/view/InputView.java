package view;

import java.util.Scanner;

public class InputView {
    private static InputView iv;
    private final Scanner sc;

    private InputView() {
        sc = new Scanner(System.in);
    }

    public static InputView getInstance() {
        if (iv == null) {
            iv = new InputView();
        }
        return iv;
    }

    public int numOfPlayers() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return getValue();
    }

    public int ladderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return getValue();
    }

    private int getValue() {
        return sc.nextInt();
    }

    public void close() {
        if (sc != null) {
            sc.close();
        }
    }
}
