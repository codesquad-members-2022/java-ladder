package application.util;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static double nextDouble() {
        return random.nextDouble();
    }
}
