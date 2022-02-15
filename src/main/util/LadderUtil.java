package main.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import main.domain.LadderElement;

public class LadderUtil {

    private static final Random random = new Random();

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }

    public static List<List<LadderElement>> create2DList(int height, int width) {
        List<List<LadderElement>> plane = new ArrayList<>();

        for (int row = 0; row < height; ++row) {
            plane.add(createList(width));
        }
        return plane;
    }

    public static List<LadderElement> createList(int width) {
        ArrayList<LadderElement> line = new ArrayList<>();

        for (int col = 0; col < width; ++col) {
            line.add(null);
        }
        return line;
    }
}
