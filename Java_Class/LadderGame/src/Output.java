import java.util.Arrays;

public class Output {
    public void printConsole(String[][] ladder) {
        Arrays.stream(ladder)
            .map(arr -> String.join("", arr))
            .forEach(System.out::println);
    }
}
