package main.domain;

import java.util.Arrays;
import java.util.List;

public interface LadderOperation {

    static LadderElement create(int col, boolean prev, boolean rand) {
        return Arrays.stream(LadderElement.values())
            .filter(e -> e.check(col, prev, rand))
            .findAny()
            .orElseThrow(IllegalStateException::new);
    }

    boolean check(int col, boolean prev, boolean rand);

    void change(List<List<LadderElement>> map, int row, int col);

    boolean next(boolean prev);
}
