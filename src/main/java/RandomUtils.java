import java.util.Random;

public class RandomUtils {
    private static final Random rnd = new Random();

    private RandomUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean nextBoolean() {
        return rnd.nextBoolean();
    }
}
