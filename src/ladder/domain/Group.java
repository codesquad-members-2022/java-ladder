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

    protected boolean containsName(String name) {
        return nameList.contains(String.format(NAME_FORMAT, name));
    }

    protected int getIndex(String name) {
        return nameList.indexOf(String.format(NAME_FORMAT, name));
    }

    protected String getName(int index) {
        return nameList.get(index);
    }

    @Override
    public String toString() {
        return nameList.stream()
                .map(s -> END_POINT_SYMBOL + s + ' ')
                .collect(Collectors.joining());
    }

    private List<String> buildNameList(String[] names, int size) {
        List<String> list = Stream.of(names)
                .map(this::formatNameToFixedLength)
                .collect(Collectors.toCollection(ArrayList::new));

        while (list.size() < size) {
            list.add(" ".repeat(NAME_LENGTH_LIMIT));
        }

        return list;
    }

    private String formatNameToFixedLength(String name) {
        return String.format(NAME_FORMAT, name);
    }
}
