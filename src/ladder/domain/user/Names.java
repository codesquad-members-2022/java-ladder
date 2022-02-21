package ladder.domain.user;

import java.util.*;
import java.util.stream.IntStream;


public class Names {

    private static final int START = 0;
    private static final int MIN_PLAYER_LIMIT = 1;
    private static final int MAX_PLAYER_LIMIT = 15;

    private final List<Name> names;

    public Names(List<Name> names) {
        validateNames(names);
        this.names = names;
    }

    private void validateNames(List<Name> names) {
        Objects.requireNonNull(names);
        validateMaxMember(names);
    }

    private void validateMaxMember(List<Name> names) {
        int playerCount = names.size();
        if (playerCount < MIN_PLAYER_LIMIT || playerCount > MAX_PLAYER_LIMIT) {
            throw new IllegalStateException();
        }
    }

    private boolean contains(String inputName) {
        return this.names.stream()
                .anyMatch(name -> equalTo(name, inputName));
    }

    public List<Name> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(this.names));
    }

    public int findNameByIndex(String name) {
        final int end = this.names.size();
        return IntStream.range(START, end)
                .filter(index -> checkNameByIndex(index, name))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean checkNameByIndex(int index, String name) {
        return getNameByIndex(index).equalTo(name);
    }

    public Name getNameByIndex(int index) {
        return names.get(index);
    }

    private boolean equalTo(Name name, String inputName) {
        return name.getName().equals(inputName);
    }

    public int size() {
        return this.names.size();
    }
}
