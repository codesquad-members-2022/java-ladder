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
        String player="";
        players = Arrays.asList(Input.getPlayer().split(","));
        results = Arrays.asList(Input.getResult().split(","));
        heightOfLadder = Input.getNumber();

        Ladder ladder = new Ladder(players, results, heightOfLadder);
        Output.messageAboutLadder(ladder.Info());
        while(!player.equals("춘식이")){
            player = Input.pickPlayer();
            Output.messageAboutResult(ladder.resultInfo(player));
        }
        Input.Close();
    }
}
