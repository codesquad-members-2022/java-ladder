package com.company;

import java.util.Arrays;

public class Print {

    public static void printSadari(Sadari sadari) {
        char[][] sadariArray = sadari.getSadari();
        for (char[] chars : sadariArray) {
            System.out.println(String.valueOf(chars));
        }
    }
}
