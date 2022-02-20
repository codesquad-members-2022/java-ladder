package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Sadari {
    private ArrayList<ArrayList<String>> sadariList = new ArrayList<ArrayList<String>>();
    private ArrayList<String> playerList;

    public Sadari(ArrayList<String> playerList, int height) {
        this.sadariList = makeSadariList(playerList.size(), height);
        this.playerList = playerList;
    }

    private ArrayList<ArrayList<String>> makeSadariList(int playerCount, int height) {
        ArrayList<ArrayList<String>> sadariList = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < height; i++) {
            sadariList.add(makeRow(playerCount));
        }
        return sadariList;
    }

    private ArrayList<String> makeRow(int playerCount) {
        ArrayList<String> Row = new ArrayList<>();
        boolean[] isLineUsed = { false };
        for (int i = 0; i < playerCount + playerCount + 1; i++) {
            Row.add(getRowComponent(playerCount, i, isLineUsed));
        }
        return Row;
    }

    private String getRowComponent(int playerCount, int index, boolean[] isLineUsed) {
        if (index == 0 || index == 2 * playerCount) {
            return "  ";
        }
        if (index % 2 == 0 && isLineUsed[0]) {
            return "     ";
        }
        if (index % 2 == 0)
            return getRandomLine(isLineUsed);
        return "|";
    }

    public ArrayList<ArrayList<String>> getSadariList() {
        return this.sadariList;
    }

    public ArrayList<String> getPlayerList() {
        return this.playerList;
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
