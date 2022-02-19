package src.ladder.utils;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM = new Random();

    public static boolean nextBooleanWithPercentOf(int percentage) {
        return RANDOM.nextFloat() * 100 <= percentage;
    }

}
