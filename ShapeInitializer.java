import java.util.stream.IntStream;

public abstract class ShapeInitializer {

    public String initEmpty(int numberOfPadding) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, numberOfPadding).forEach(i -> sb.append(" "));
        return sb.toString();
    }

    public String initBridge(int numberOfPadding) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, numberOfPadding).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
