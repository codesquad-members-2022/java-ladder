package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Sadari {
    private ArrayList<ArrayList<String>> sadariList = new ArrayList<ArrayList<String>>();
    private ArrayList<String> people;

    public Sadari(int peopleCount, int height) {
        this.sadariList = makeSadariList(peopleCount, height);
    }

    public void setUsers() {
        ArrayList<String> namesList = Input.getNamesList();
    }

    private ArrayList<ArrayList<String>> makeSadariList(int peopleCount, int height) {
        ArrayList<ArrayList<String>> sadariList = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < height; i++) {
            sadariList.add(makeRow(peopleCount));
        }
        return sadariList;
    }

    private ArrayList<String> makeRow(int peopleCount) {
        ArrayList<String> Row = new ArrayList<>();
        boolean[] isLineUsed = { false };
        for (int i = 0; i < peopleCount + peopleCount + 1; i++) {
            Row.add(getRowComponent(peopleCount, i, isLineUsed));
        }
        return Row;
    }

    private String getRowComponent(int peopleCount, int index, boolean[] isLineUsed) {
        if (index == 0 || index % 2 == 0 && isLineUsed[0]) {
            return "     ";
        }
        if (index == 2 * peopleCount) {
            return "    ";
        }
        if (index % 2 == 0)
            return getRandomLine(isLineUsed);
        return "|";
    }

    public ArrayList<ArrayList<String>> getSadariList() {
        return this.sadariList;
    }

    private String getRandomLine(boolean[] isLineUsed) {
        Random random = new Random();
        boolean isLine = false;
        if (!isLineUsed[0]) {
            isLine = random.nextBoolean();
            isLineUsed[0] = isLine;
        }
        if (isLine)
            return "-----";
        return "     ";
    }
}
