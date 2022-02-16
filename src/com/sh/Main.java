package com.sh;

import static com.sh.utils.Input.*;

import java.util.List;

public class Main {
    private static Configuration configuration = Configuration.getInstance();

    public static void main(String[] args) {
        var settings = configuration.getSettings();
        List<String> names = settings.getListOfNames();
        int height = settings.getHeight(names.size());


        // Ladder ladder = new Ladder(numberOfPeoples, height);
        // ladder.play();
        // boolean[][] ladders = ladder.getLadders();
        //
        // println.accept(resultOfPlay(ladders));

        scanClose();
    }
}
