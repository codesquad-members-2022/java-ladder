package main.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import main.domain.Player;

public class InputUtil {

    public static List<String> parseEntries(String line) throws IllegalArgumentException {
        List<String> entries = List.of(line.split(","));

        for (String entry : entries) {
            validateEntry(entry);
        }
        return entries;
    }

    private static void validateEntry(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Player> parsePlayers(String line) throws IllegalArgumentException {
        List<String> names = parseEntries(line);

        return IntStream.range(0, names.size())
            .mapToObj(ind -> new Player(names.get(ind), ind))
            .collect(Collectors.toList());
    }

    public static List<String> parseOutcomes(String line, int size)
        throws IllegalArgumentException {
        List<String> results = parseEntries(line);

        if (results.size() != size) {
            throw new IllegalArgumentException();
        }
        return results;
    }

    public static char[] fillNull(int length) {
        char[] arr = new char[length];
        Arrays.fill(arr, ' ');

        return arr;
    }

}
