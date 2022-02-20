package com.company;

import java.util.ArrayList;

public class Controller {

    void init() {
        ArrayList<String> namesList = Input.getPlayerList();
        int height = Input.getSadariHeight();
        Sadari sadari = new Sadari(namesList, height);
        Print.printGame(sadari);
    }

}
