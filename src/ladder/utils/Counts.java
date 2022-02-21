package ladder.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Counts {

    private static final int START = 1;
    private static final int LIMIT = 15;
    private static final List<Count> counts = new ArrayList<>();

    static {
        initCounts();
    }

    private static void initCounts() {
        List<Count> elements = new ArrayList<>(IntStream.rangeClosed(START, LIMIT)
                .mapToObj(Count::new)
                .collect(Collectors.toUnmodifiableList()));
        counts.addAll(elements);
    }

    public static Count of(int number) {
        return counts.stream()
                .filter(count -> equalTo(count, number))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private static boolean equalTo(Count count, int number) {
        return count.getValue() == number;
    }
}
