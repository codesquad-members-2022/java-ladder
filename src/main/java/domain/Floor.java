package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floor {

    private static final String VERTICAL = "|";
    private static final String LINE = "-----";
    private static final String BLANK = " ";
    private static final Random random = new Random();

    private final List<String> floor;

    public Floor(int size) {
        this.floor = generateFloor(size);
    }

    private List<String> generateFloor(int size) {
        List<String> parts = new ArrayList<>();
        for (int i = 0; i < size ; i++) {
            parts.add(drawPart(parts,i));
        }
        return parts;
    }

    private String generateLine(boolean b) {
        if (b) {
            return LINE;
        }
        return BLANK;
    }

    private String generateRandomLine(List<String> list, int index) {
        if (index == 1) {
            return generateLine(random.nextBoolean());
        }
        if (list.get(index - 2).equals(BLANK)) {
            return generateLine(random.nextBoolean());
        }
        return BLANK;
    }

    private String drawPart(List<String> list, int index) {
        if(index % 2 == 0) {
            return VERTICAL;
        }
        return generateRandomLine(list,index);
    }


}
