package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {

    private List<String> names;

    public Names(String names) {
        this.names = splitNames(names);
    }

    private List<String> splitNames(String names) {
        List<String> nameList = new ArrayList<>();
        String[] arr = names.split(",");
        Collections.addAll(nameList, arr);
        return nameList;
    }

    public int getPlayersCount() {
        return names.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(String.format("%6s", name));
        }
        return stringBuilder.toString();
    }
}
