import java.util.Arrays;

public class OutputManager {
    public void println(String message) {
        System.out.println(message);
    }

    public void println(Ladder ladder) {
        ladder.getLadder().stream()
                .forEach(System.out::println);
    }
}
