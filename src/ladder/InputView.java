package ladder;

import java.util.Scanner;

public class InputView {
    private String participantsQuestion = "참여할 사람은 몇 명인가요?";
    private String heightQuestion = "사다리의 높이는 얼마인가요?";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getParticipantsNum() {
        System.out.println(participantsQuestion);
        return scanner.nextInt();
    }

    public int getLadderHeight() {
        System.out.println(heightQuestion);
        return scanner.nextInt();
    }

}
