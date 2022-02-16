package com.sh;

import static com.sh.utils.Input.*;
import static com.sh.utils.Output.*;

import java.util.List;

import com.sh.domains.Players;

public class Main {
    private static Configuration configuration = Configuration.getInstance();

    public static void main(String[] args) {
        var settings = configuration.getSettings();
        List<String> names = settings.getListOfNames();
        int height = settings.getHeight(names.size());

        Players players = new Players(names);
        Ladder ladder = new Ladder(players.numberOf(), height);

        System.out.println(names);

        ladder.play();
        List<List<Boolean>> ladders = ladder.getLadders();
        for (List<Boolean> line : ladders) {
            prints.accept(line);
        }
        // println.accept(resultOfPlay(ladders));

        scanClose();
    }
}
