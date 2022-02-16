import java.util.Arrays;

public class OutputManager {
    public void println(String message) {
        System.out.println(message);
    }

    public void printLadderModel(Ladder ladder) {
        Arrays.stream(ladder.getNameTags())
                .forEach(System.out::print);
        println("");
        ladder.getLadder().stream()
                .forEach(System.out::println);
    }
}
