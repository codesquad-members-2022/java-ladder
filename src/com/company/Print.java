package com.company;

import java.util.ArrayList;
import java.util.List;

public class Print {

    public static void printSadari(Sadari sadari) {
        ArrayList<String> namesList = sadari.getNamesList();
        for (String name : namesList) {
            StringBuilder sb = new StringBuilder();
            final int SPACE_PER_NAME = 5;
            int leftPadding = switch (name.length()) {
                case 4, 3 -> 1;
                case 2, 1 -> 2;
                default -> 0;
            };
            for (int i = 0; i < leftPadding; i++) {
                sb.append(" ");
            }
            sb.append(name);
            for (int i = 0; i < SPACE_PER_NAME - leftPadding - name.length(); i++) {
                sb.append(" ");
            }
            System.out.print(sb.toString());
            System.out.print(" ");
        }
        System.out.println();

        ArrayList<ArrayList<String>> sadariArray = sadari.getSadariList();

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
