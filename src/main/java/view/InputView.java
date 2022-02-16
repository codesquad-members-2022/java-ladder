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

    public String playerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return getLine();
    }

    public int ladderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return getValue();
    }

    private int getValue() {
        return sc.nextInt();
    }

    private String getLine() {
        return sc.next();
    }

    public void close() {
        if (sc != null) {
            sc.close();
        }
    }
}
