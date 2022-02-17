package ladder.utils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtils {

    private CopyUtils() {}

    public static <T> List<T> copy(List<T> elements) {
        return new ArrayList<>(elements);
    }
}
