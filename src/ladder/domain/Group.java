package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group {
    public static final int NAME_LENGTH_LIMIT = 5;
    private final List<String> nameList;

    public Group(String[] names) {
        this.nameList = buildNameList(names, names.length);
    }

    public Group(String[] names, int size) {
        this.nameList = buildNameList(names, size);
    }

    public int count() {
        return nameList.size();
    }

    public boolean containsName(String name) {
        return nameList.contains(name);
    }

    public int getIndex(String name) {
        return nameList.indexOf(name);
    }

    public String getName(int index) {
        return nameList.get(index);
    }

    private List<String> buildNameList(String[] names, int size) {
        List<String> list = Stream.of(names)
                .limit(size)
                .map(this::truncate)
                .collect(Collectors.toCollection(ArrayList::new));

        while (list.size() < size) {
            list.add("");
        }

        return list;
    }

    private String truncate(String name) {
        if (name.length() <= NAME_LENGTH_LIMIT) {
            return name;
        }

        return name.substring(0, NAME_LENGTH_LIMIT);
    }
}
