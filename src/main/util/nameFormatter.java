package main.util;

public class nameFormatter {

    public static final int MAX_LENGTH = InputValidator.MAXIMUM_NAME_LENGTH;

    public static String blankPadding(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_LENGTH; i++) {
            sb.append(" ");
        }
        int startIndex = MAX_LENGTH/2 - name.length()/2;
        sb.replace(startIndex, startIndex+name.length(), name);
        return sb.toString();
    }
}
