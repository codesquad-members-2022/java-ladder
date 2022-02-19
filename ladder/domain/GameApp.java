package ladder.domain;

import ladder.view.GameDisplay;
import ladder.view.UserInterface;

import java.util.ArrayList;

public class GameApp {

    public void run() {
        UserInterface ui = new UserInterface();
        LadderProcessor lp = new LadderProcessor();
        ArrayList<String> players = ui.inputPlayerList();
        if (players == null) return;

        GameDisplay.showLadderGameInfo(players, lp.getLadderInfo(players.size(), ui.inputLadderHeight()));
    }

}
