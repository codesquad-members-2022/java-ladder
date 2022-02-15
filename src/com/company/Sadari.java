package com.company;

import java.util.Random;

public class Sadari {
    char[][] sadari;
    String[] people;

    public Sadari(int peopleCount, int height) {
        this.sadari = makeSadariArray(peopleCount, height);
    }

    private char[][] makeSadariArray(int peopleCount, int height) {
        char[][] sadari = new char[height][peopleCount + peopleCount - 1 ];
        for (int i = 0; i < height; i++) {
            char[] line = new char[peopleCount + peopleCount - 1];
            for (int j = 0; j < peopleCount + peopleCount - 1; j++) {
                if (j % 2 == 0) {
                    line[j] = '|';
                } else {
                    if (getRandomLine()) {
                        line[j] = '-';
                    } else {
                        line[j] = ' ';
                    }
                }
            }
            sadari[i] = line;
        }
        return sadari;
    }

    public char[][] getSadari() {
        return this.sadari;
    }

    private boolean getRandomLine() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
