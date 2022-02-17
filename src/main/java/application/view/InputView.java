package application.view;

import java.util.Scanner;

import static application.domain.message.GameMessage.*;

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
        return sc.next();
    }

    public int ladderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT);
        return sc.nextInt();
    }

    public void close() {
        if (sc != null) {
            sc.close();
        }
    }
}
