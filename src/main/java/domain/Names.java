package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {

    private List<String> names;

    public Names(String names) {
        this.names = new ArrayList<>();
        putNames(names);
    }

    private void putNames(String names) {
        String[] arr = names.split(",");
        Collections.addAll(this.names, arr);
    }
}
