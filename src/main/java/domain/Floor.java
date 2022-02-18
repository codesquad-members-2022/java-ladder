package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Floor {

    private static final String START_VERTICAL = "    |";
    private static final String STEP = "-----|";
    private static final String BLANK = "     |";
    private static final Random random = new Random();

    private final List<Boolean> floor;

    public Floor(int size) {
        this.floor = generateFloor(size);
    }

    public boolean isSTEP(int index) {
        if (index > floor.size() - 1) {
            return false;
        }
        if (floor.get(index) == null) {
            return false;
        }
        return floor.get(index);
    }

    private List<Boolean> generateFloor(int size) {
        List<Boolean> parts = new ArrayList<>();
        parts.add(null);
        for (int i = 1; i <= size; i++) {
            parts.add(drawPart(parts, i));
        }
        parts.add(null);
        return parts;
    }

    private boolean drawPart(List<Boolean> floor, int index) {
        if (floor.get(index - 1) == null) {
            return drawRandom();
        }
        if (floor.get(index - 1)) {
            return false;
        }
        return drawRandom();
    }

    private boolean drawRandom() {
        return random.nextBoolean();
    }

    private String toText(boolean b) {
        if (b) {
            return STEP;
        }
        return BLANK;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START_VERTICAL);
        floor.stream().sequential().filter(Objects::nonNull).map(this::toText).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
