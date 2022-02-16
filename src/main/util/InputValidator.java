package main.util;

import java.util.List;

public class InputValidator {

    public static void checkName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Incorrect input: 5 or less character is required");
        }
    }

    public static void checkNumOfName(List<String> list) throws IllegalArgumentException {
        if (list.size() <= 1) {
            throw new IllegalArgumentException("Incorrect input: 2 or more name is required");
        }
    }


    public static void checkPositiveInt(int num) throws IllegalArgumentException {
        if (num <= 0) {
            throw new IllegalArgumentException("Incorrect input: positive integer is required");
        }
    }
}
