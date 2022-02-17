package domain;

import java.util.List;
import java.util.Random;

public class Line {

    private static final String LINE = "-----";
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

    public String generateRandomLine(List<String> list, int index) {
        if(index == 1) {
            return generateLine(random.nextBoolean());
        }
        if(list.get(index-2).equals(BLANK)) {
            return generateLine(random.nextBoolean());
        }
        return BLANK;
    }
}

