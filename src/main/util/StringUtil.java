package main.util;

import java.util.Arrays;
import java.util.List;
import main.LadderElement;

public class StringUtil {

    public static List<String> parseNames(String line) {
        List<String> names = List.of(line.split(","));

        for (String name : names) {
            validateName(name);
        }
        return names;
    }

    public static String wrapName(String name) {
        int gap = LadderElement.getGap();
        int margin = gap / 2 - name.length() / 2;

        char[] wrap = new char[gap];
        Arrays.fill(wrap, ' ');

        for (int ind = 0; ind < name.length(); ind++) {
            wrap[ind + margin] = name.charAt(ind);
        }
        return new String(wrap);
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
