package com.sh;

import static com.sh.utils.Input.*;
import static com.sh.utils.Output.*;

import java.util.List;

import com.sh.domains.Ladder;
import com.sh.domains.LadderService;
import com.sh.domains.Players;

public class Main {
    private static Configuration configuration = Configuration.getInstance();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        try {
            var settings = configuration.getSettings();
            List<String> names = settings.getListOfNames();
            int height = settings.getHeight(names.size());

            Players players = new Players(names);
            Ladder ladder = new Ladder(players.numberOf(), height);

            LadderService service = new LadderService(players, ladder);
            String result = service.resultOfPlay();
            println.accept(result);

            scanClose();
        } catch (IllegalArgumentException | NullPointerException exception) {
            println.accept(exception.getMessage());
            run();
        }
    }
}
