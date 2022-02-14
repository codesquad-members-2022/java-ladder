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
        outputView.printMessage(Message.INPUT_NUM_PERSON.get());
        return scanner.nextInt();
    }

    public int getNumLadder() {
        outputView.printMessage(Message.INPUT_NUM_LADDER.get());
        return scanner.nextInt();
    }
}
