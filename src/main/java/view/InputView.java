package view;

import java.util.Scanner;

import static message.GameMessage.*;

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
        System.out.println(REQUEST_PLAYER_NAMES);
        return getLine();
    }

    public int ladderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT);
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
