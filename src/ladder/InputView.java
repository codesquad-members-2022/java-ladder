package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String participantsQuestion = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String heightQuestion = "사다리의 높이는 얼마인가요?";
    private Scanner scanner;
    private Validator validator;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        this.validator = new Validator();
    }
    
    public List<String> getParticipants() {
        System.out.println(participantsQuestion);
        List<String> participants = parsingParticipants();
        return participants;
    }

    public int getLadderHeight() {
        System.out.println(heightQuestion);
        return scanner.nextInt();
    }

    private List<String> parsingParticipants() {
        String[] participantArr = scanner.nextLine().split(",");
        List<String> participants = new ArrayList<>(Arrays.asList(participantArr));
        return participants;
    }

}
