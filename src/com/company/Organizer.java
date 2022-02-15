package com.company;

public class Organizer {
    int[] getSadariInfo() {
        int peopleCount = Input.getPeopleCount();
        int sadariHeight = Input.getSadariHeight();
        int[] answer = new int[]{peopleCount, sadariHeight};
        return answer;
    }

    void init() {
        int[] sadariInfo = getSadariInfo();
        Sadari sadari = new Sadari(sadariInfo[0], sadariInfo[1]);
        Print.printSadari(sadari);
    }

}
