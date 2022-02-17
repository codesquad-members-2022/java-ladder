package Ladder.util;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
