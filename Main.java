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
        out.println(Message.NUBER_OF_PEOPLE.get());
        return in.inputNumber();
    }

    public static int enterLadderDepth() {
        out.println(Message.DEPTH_OF_LADDER.get());
        return in.inputNumber();
    }
}
