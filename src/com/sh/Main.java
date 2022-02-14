package com.sh;

import static com.sh.utils.Input.*;
import static com.sh.utils.Output.*;

public class Main {
    public static void main(String[] args) {
        int numberOfPeoples = getNumbers();
        int height = getHeight(numberOfPeoples);

        Ladder ladder = new Ladder(numberOfPeoples, height);
        ladder.play();
        boolean[][] ladders = ladder.getLadders();

        println.accept(resultOfPlay(ladders));

        scanClose();
    }
}
