import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static InputManager in = new InputManager();
    private static OutputManager out = new OutputManager();

    public static void main(String[] args) {
        Ladder ladder = new Ladder(enterNumberOfPeople(), enterLadderDepth());
        out.println("");
        out.println(ladder);
    }

    public static int enterNumberOfPeople() {
        out.println("참여할 사람은 몇 명인가요?");
        return in.inputNumber();
    }

    public static int enterLadderDepth() {
        out.println("최대 사다리 높이는 몇 개인가요?");
        return in.inputNumber();
    }
}
