package com.company;

public class Print {

    public static void printSadari(Sadari sadari) {
        char[][] sadariArray = sadari.getSadariArray();
        for (char[] chars : sadariArray) {
            System.out.println(String.valueOf(chars));
        }
    }
}
