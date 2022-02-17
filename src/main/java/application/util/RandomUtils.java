package application.util;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static double nextDouble() {
        return random.nextDouble();
    }
}
