package com.company;

import java.util.Random;

public class Sadari {
    char[][] sadariArray;
    String[] people;

    public Sadari(int peopleCount, int height) {
        this.sadariArray = makeSadariArray(peopleCount, height);
    }

    private char[][] makeSadariArray(int peopleCount, int height) {
        char[][] sadariArray = new char[height][peopleCount + peopleCount - 1];
        for (int i = 0; i < height; i++) {
            sadariArray[i] = makeRow(peopleCount);
        }
        return sadariArray;
    }

    private char[] makeRow(int peopleCount) {
        char[] Row = new char[peopleCount + peopleCount - 1];
        for (int i = 0; i < peopleCount + peopleCount - 1; i++) {
            Row[i] = getRowComponent(i);
        }
        return Row;
    }

    private char getRowComponent(int index) {
        if (index % 2 == 0)
            return '|';
        if (getRandomLine())
            return '-';
        return ' ';
    }

    public char[][] getSadariArray() {
        return this.sadariArray;
    }

    private boolean getRandomLine() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
