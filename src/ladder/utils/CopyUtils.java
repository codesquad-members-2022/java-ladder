package ladder.utils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtils<T> {

    private CopyUtils() {}

    public static <T> List<T> copy(List<T> elements) {
        return new ArrayList<>(elements);
    }

    public static <T> T copy(T element) {
        return element;
    }
}