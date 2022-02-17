package domain;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static Boolean putLine(boolean forwardVoid) {
        return forwardVoid && random.nextBoolean();
    }
}
