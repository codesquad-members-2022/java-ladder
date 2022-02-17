package ladder.domain.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Names {

    private static final int START = 0;

    private final List<Name> names;

    public Names(List<Name> names) {
        validateNames(names);
        this.names = names;
    }

    private void validateNames(List<Name> names) {
        Objects.requireNonNull(names);
    }

    public List<Name> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(names));
    }

    public int findNameByIndex(String name) {
        final int end = this.names.size();
        return IntStream.range(START, end)
                .filter(index -> checkNameByIndex(index, name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean checkNameByIndex(int index, String name) {
        return getNameByIndex(index).equalTo(name);
    }

    public Name getNameByIndex(int index) {
        return names.get(index);
    }

    public int size() {
        return names.size();
    }

}
