package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group {
    public static final int NAME_LENGTH_LIMIT = 5;
    private static final String NAME_FORMAT = String.format("%%-%1$d.%1$ds", NAME_LENGTH_LIMIT);
    private static final char END_POINT_SYMBOL = '*';
    private final List<String> nameList;

    protected Group(String[] names) {
        this.nameList = buildNameList(names, names.length);
    }

    protected Group(String[] names, int size) {
        this.nameList = buildNameList(names, size);
    }

    protected int count() {
        return nameList.size();
    }

    @Override
    public String toString() {
        return nameList.stream()
                .map(s -> END_POINT_SYMBOL + s + ' ')
                .collect(Collectors.joining());
    }

    private List<String> buildNameList(String[] names, int size) {
        return Stream.of(names)
                .limit(size)
                .map(this::truncate)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private String truncate(String name) {
        return String.format(NAME_FORMAT, name);
    }
}
