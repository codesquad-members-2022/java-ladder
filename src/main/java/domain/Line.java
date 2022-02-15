package domain;

import java.util.Random;

public class Line {

    private static final String LINE = "-";
    private static final String BLANK = " ";
    private final Random random;

    public Line() {
        random = new Random();
    }

    public String generateLine(boolean b) {
        if(b) {
            return LINE;
        }
        return BLANK;
    }

    public String generateRandomLine() {
        return generateLine(random.nextBoolean());
    }

}

