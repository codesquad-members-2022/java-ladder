package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Names {

    private static final int START = 0;

    private final List<Name> names;

    public Names(List<Name> names) {
        if (names.isEmpty()) {
            this.names = Collections.emptyList();
            return;
        }
        this.names = names;
    }

    public List<Name> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(names));
    }

    public int getSize() {
        return names.size();
    }

    public int checkNameByIndex(String name) {
        final int end = names.size();
        return IntStream.range(START, end)
                .filter(index -> checkNameByIndex(index, name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean checkNameByIndex(int index, String name) {
        return get(index).equalTo(name);
    }

    public Name get(int index) {
        return names.get(index);
    }

    public int size() {
        return names.size();
    }
}
