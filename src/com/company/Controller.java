package com.company;

public class Controller {
    int[] getSadariInfo() {
        int peopleCount = Input.getPeopleCount();
        int sadariHeight = Input.getSadariHeight();
        return new int[]{peopleCount, sadariHeight};
    }

    void init() {
        int[] sadariInfo = getSadariInfo();
        Sadari sadari = new Sadari(sadariInfo[0], sadariInfo[1]);
        Print.printSadari(sadari);
    }

}
