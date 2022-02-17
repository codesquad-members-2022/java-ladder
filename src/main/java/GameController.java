import java.util.Arrays;

public class GameController {

    public void run() {
        String usernames = InputUtil.getUserNameInput();;
        int lineHeight = InputUtil.getLadderSizeInput();

        Ladder ladder = new Ladder(Arrays.asList(usernames.split(",")), lineHeight);
        OutputUtil.printLadder(ladder.toString());
    }

}
