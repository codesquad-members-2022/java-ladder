package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floor {

    private static Random random = new Random();

    private final int size;
    private final List<Boolean> floor;

    public Floor(int size, List<Boolean> floor) {
        this.size = size;
        this.floor = floor;
    }

    private Floor(int size) {
        this.size = size;
        this.floor = new ArrayList<>();
    }

    public static Floor getInstance(int size) {
        Floor floor = new Floor(size);
        floor.generateFloor(floor.generateRandomStep());
        return floor;
    }

    public boolean isSTEP(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        return floor.get(index);
    }

    public void generateFloor(List<Boolean> booleans) {
        if (booleans.size() > this.size) {
            throw new IllegalArgumentException();
        }
        floor.addAll(booleans);
    }

    private List<Boolean> generateRandomStep() {
        List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < this.size ; i++) {
            booleans.add(drawPart(booleans,i));
        }
        return booleans;
    }

    private boolean drawPart(List<Boolean> booleans, int index) {
        if (index == 0) {
            return drawRandom();
        }
        if (booleans.get(index - 1)) {
            return false;
        }
        return drawRandom();
    }

    private boolean drawRandom() {
        return random.nextBoolean();
    }

}
