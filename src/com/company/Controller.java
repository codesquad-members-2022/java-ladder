package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.Input.getNamesList;

public class Controller {

    void init() {
        ArrayList<String> namesList = Input.getNamesList();
        System.out.println(namesList.toString());
        int height = Input.getSadariHeight();
        Sadari sadari = new Sadari(namesList, height);
        Print.printSadari(sadari);
    }

}
