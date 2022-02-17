package main.util;

import java.util.Arrays;
import java.util.List;

public class InputUtil {

    public static List<String> parseEntries(String line) throws IllegalArgumentException {
        List<String> names = List.of(line.split(","));

        for (String name : names) {
            validateElement(name);
        }
        return names;
    }

    public static List<String> parseResults(String line, int size) throws IllegalArgumentException {
        List<String> results = parseEntries(line);

        if (results.size() != size) {
            throw new IllegalArgumentException();
        }
        return results;
    }

    private static void validateElement(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static char[] fillNull(int length) {
        char[] arr = new char[length];
        Arrays.fill(arr, ' ');

        return arr;
    }

}
