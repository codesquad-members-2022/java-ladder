package ladder.utils;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();

    private RandomGenerator (){};
    private static final RandomGenerator instance = new RandomGenerator();

    public static RandomGenerator getInstance() {
        if (instance == null) {
            return new RandomGenerator();
        }
        return instance;
    }

    public static int getValue(){
        return (random.nextInt()+10)%2;
    }
}
