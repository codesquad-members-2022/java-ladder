import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int LIMIT_NAME_LENGTH = 5;

    private static InputManager in = new InputManager();
    private static OutputManager out = new OutputManager();

    public static void main(String[] args) {
        Ladder ladder = new Ladder(enterPeoples(), enterLadderDepth());
        out.println("");
        out.println(ladder);
    }

    public static String[] enterPeoples() {
        out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] peoples = in.separateCommasFromString(in.inputString());
        try {
            in.validatePlayerNameLength(peoples, LIMIT_NAME_LENGTH);
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
            enterPeoples();
        }
        return peoples;
    }

    public static int enterLadderDepth() {
        out.println("최대 사다리 높이는 몇 개인가요?");
        return in.inputNumber();
    }
}
