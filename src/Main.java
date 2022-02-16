import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> players;
        int heightOfLadder;
        Output.messageAboutPlayer();
        players = Arrays.asList(Input.getPlayer().split(","));

        Output.messageAboutHeight();
        heightOfLadder = Input.getNumber();

        Input.Close();

        Ladder ladder = new Ladder(players, heightOfLadder);
        Output.messageAboutLadder(ladder.Info());
    }
}
