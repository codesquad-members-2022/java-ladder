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
        for (int i = 0; i < peopleCount + peopleCount + 1; i++) {
            Row.add(getRowComponent(peopleCount, i));
        }
        return Row;
    }

    private String getRowComponent(int peopleCount, int index) {
        if (index == 0) {
            return "     ";
        }
        if (index == 2 * peopleCount) {
            return "    ";
        }
        if (index % 2 == 0)
            return "-----";
        return "|";
    }

    public ArrayList<ArrayList<String>> getSadariList() {
        return this.sadariList;
    }

    private boolean getRandomLine() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
