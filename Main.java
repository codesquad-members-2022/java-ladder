import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static InputManager in = new InputManager();
    private static OutputManager out = new OutputManager();

    public static void main(String[] args) {
        Ladder ladder = new Ladder(enterNames(), enterLadderDepth());
        out.println("");
        out.printLadderModel(ladder);
    }

    public static String[] enterNames() {
        out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = in.separateCommasFromString(in.inputString());
        try {
            in.validateNameLength(names);
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
            enterNames();
        }
        return names;
    }

    public static int enterLadderDepth() {
        out.println("최대 사다리 높이는 몇 개인가요?");
        return in.inputNumber();
    }
}
