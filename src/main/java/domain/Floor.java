package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Floor {

    private static Random random = new Random();

    private final int size;
    private final List<Boolean> floor;

    public Floor(int size) {
        this.size = size;
        this.floor = new ArrayList<>();
    }

    public static Floor getInstance(int size) {
        Floor floor = new Floor(size);
        floor.generateFloor();
        return floor;
    }

    public boolean isSTEP(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        return floor.get(index);
    }

    private void generateFloor() {
        for (int i = 1; i <= this.size; i++) {
            floor.add(drawPart(floor, i));
        }
    }

    private boolean drawPart(List<Boolean> floor, int index) {
        if (index == 0) {
            return drawRandom();
        }
        if (isSTEP(index - 1)) {
            return false;
        }
        return drawRandom();
    }

    private boolean drawRandom() {
        return random.nextBoolean();
    }

}
