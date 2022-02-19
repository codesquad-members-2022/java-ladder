import domain.Ladder;
import view.Input;
import view.Output;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> players;
        List<String> results;
        int heightOfLadder;
        players = Arrays.asList(Input.getPlayer().split(","));
        results = Arrays.asList(Input.getResult().split(","));
        heightOfLadder = Input.getNumber();

        Input.Close();

        Ladder ladder = new Ladder(players, results, heightOfLadder);
        Output.messageAboutLadder(ladder.Info());
    }
}
