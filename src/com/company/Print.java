package com.company;

import java.util.ArrayList;
import java.util.List;

public class Print {

    public static void printSadari(Sadari sadari) {
        ArrayList<ArrayList<String>> sadariArray = sadari.getSadariList();
        for (ArrayList<String> row : sadariArray) {
            System.out.println(row.toString());
        }
    }
}
