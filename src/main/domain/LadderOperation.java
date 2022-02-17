package main.domain;

import java.util.Arrays;

public interface LadderOperation {

    static LadderElement create(int col, boolean next, boolean rand) {
        return Arrays.stream(LadderElement.values())
            .filter(e -> e.check(col, next, rand))
            .findAny()
            .orElseThrow(IllegalStateException::new);
    }

    boolean check(int ind, boolean next, boolean rand);

    boolean getNext(boolean prev);
}
