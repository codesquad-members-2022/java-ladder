package util;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static double nextDouble() {
        return random.nextDouble();
    }
}
