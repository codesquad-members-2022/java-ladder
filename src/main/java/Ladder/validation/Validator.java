package Ladder.validation;

import java.util.Arrays;

public class Validator {

    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    public static boolean isNameMaxLengthFive(String playerNames) {
        String[] splitName = playerNames.split(PLAYER_NAME_DELIMITER);

        int satisfiedNameCount = (int) Arrays.stream(splitName)
                .filter(name -> name.length() <= MAX_NAME_LENGTH)
                .count();
        int allNameCount = splitName.length;

        return satisfiedNameCount == allNameCount;
    }
}
