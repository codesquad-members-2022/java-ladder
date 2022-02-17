package util;

import java.util.Random;

public class RandomUtils {
    private static Random random;

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
