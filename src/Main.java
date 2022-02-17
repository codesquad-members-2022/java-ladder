import domain.Ladder;
import view.Input;
import view.Output;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> players;
        int heightOfLadder;
        players = Arrays.asList(Input.getPlayer().split(","));
        heightOfLadder = Input.getNumber();

        Input.Close();

        Ladder ladder = new Ladder(players, heightOfLadder);
        Output.messageAboutLadder(ladder.Info());
    }
}
