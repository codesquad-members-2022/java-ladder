package com.company;

import java.util.ArrayList;
import java.util.List;

public class Print {

    public static void printSadari(Sadari sadari) {
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
