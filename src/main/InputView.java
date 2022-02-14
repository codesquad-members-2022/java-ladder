package main;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final OutputView outputView;

    public InputView(Scanner scanner, OutputView outputView) {
        this.scanner = scanner;
        this.outputView = outputView;
    }

    public int getNumPerson() {
        outputView.printMessage("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    public int getNumLadder() {
        outputView.printMessage("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
