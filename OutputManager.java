import java.util.Arrays;

public class OutputManager {
    public void println(String message) {
        System.out.println(message);
    }

    public void println(Ladder ladder) {
        Arrays.stream(ladder.getLadder())
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
    }
}
