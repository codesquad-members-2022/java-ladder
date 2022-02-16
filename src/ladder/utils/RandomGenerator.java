package ladder.utils;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();
    private static final int RANGE = 10;
    private static final int DIVISION = 2;

    private RandomGenerator() {};

    private static final RandomGenerator instance = new RandomGenerator();

    public static RandomGenerator getInstance() {
        if (instance == null) {
            return new RandomGenerator();
        }
        return instance;
    }

    public static int getValue() {
        return (random.nextInt() + RANGE) % DIVISION;
    }

    public boolean getBoolean(){
        return random.nextBoolean();
    }
}
