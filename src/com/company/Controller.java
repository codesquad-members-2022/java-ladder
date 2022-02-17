package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.Input.getNamesList;

public class Controller {

    void init() {
        List<String> namesList = Input.getNamesList();
        int height = Input.getSadariHeight();
        Sadari sadari = new Sadari(sadariInfo[0], sadariInfo[1]);
        Print.printSadari(sadari);
    }

}
