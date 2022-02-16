package main.util;

import java.util.List;

public class InputUtil {

    public static List<String> parseNames(String line) throws IllegalArgumentException {
        List<String> names = List.of(line.split(","));

        for (String name : names) {
            validateName(name);
        }
        return names;
    }

    private static void validateName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
