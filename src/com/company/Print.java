package com.company;

import java.util.ArrayList;

public class Print {

    public static void printGame(Sadari sadari) {
        ArrayList<String> namesList = sadari.getPlayerList();
        printPlayerList(namesList);

        ArrayList<ArrayList<String>> sadariArray = sadari.getSadariList();
        printSadari(sadariArray);

    }

    public static void printPlayerList(ArrayList<String> namesList) {
        for (String name : namesList) {
            System.out.print(addPaddingToName(name));
        }
        System.out.println();
    }

    public static String addPaddingToName(String name) {
        StringBuilder sb = new StringBuilder();
        final int SPACE_PER_NAME = 5;
        int leftPadding = switch (name.length()) {
            case 4, 3 -> 1;
            case 2, 1 -> 2;
            default -> 0;
        };
        sb.append(" ".repeat(leftPadding));
        sb.append(name);
        sb.append(" ".repeat(SPACE_PER_NAME - leftPadding - name.length() + 1));
        return sb.toString();
    }

    public static void printSadari(ArrayList<ArrayList<String>> sadariArray) {
        for (ArrayList<String> row : sadariArray) {
            String rowString = interpretRow(row);
            System.out.println(rowString);
        }
    }

    public static String interpretRow(ArrayList<String> row) {
        StringBuilder sb = new StringBuilder();
        for (String component : row) {
            sb.append(component);
        }
        return sb.toString();
    }
}
