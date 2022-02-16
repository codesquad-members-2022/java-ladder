package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Counts {

    private static final int LIMIT = 50;
    private static final List<Count> counts = new ArrayList<>();

    static {
        for (int index = 0; index < LIMIT; index++) {
            counts.add(new Count(index));
        }
    }

    private static Count of(int number) {
        return counts.stream()
                .filter(count -> isSameValue(count, number))
                .findAny()
                .orElseThrow();
    }

    private static boolean isSameValue(Count count, int number) {
        return count.getValue() == number;
    }

}
