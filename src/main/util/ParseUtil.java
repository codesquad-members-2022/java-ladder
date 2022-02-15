package main.util;

import java.util.List;

public class ParseUtil {

    public static List<String> parseNames(String line) {
        return List.of(line.split(","));
    }

}
