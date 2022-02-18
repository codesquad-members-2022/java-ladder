import domain.Game;
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

        //Input 수정해서 Ladder로 넘겨버리자(코드 간결성)
        players = Arrays.asList(Input.getPlayer().split(","));
        results = Arrays.asList(Input.getResult().split(","));
        heightOfLadder = Input.getNumber();

        Ladder ladder = new Ladder(players, results, heightOfLadder);
        Output.messageAboutLadder(ladder);
        Game game = new Game(ladder);
        while(!player.equals("춘식이")){
            player = Input.pickPlayer();
            Output.messageAboutGame(game.play(player));
        }
        Input.Close();
    }
}
