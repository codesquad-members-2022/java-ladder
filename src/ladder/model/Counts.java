package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Counts {

    private static final int LIMIT = 50;
    private static final List<Count> counts = new ArrayList<>();

    static {
        for (int index = 1; index < LIMIT; index++) {
            counts.add(new Count(index));
        }
    }

    private static Count of(int number) {
        return counts.stream()
                .filter(count -> equalTo(count, number))
                .findAny()
                .orElseThrow();
    }

    private static boolean equalTo(Count count, int number) {
        return count.getValue() == number;
    }
}
