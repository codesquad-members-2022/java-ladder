import java.util.Random;
import java.util.stream.IntStream;

public class GameApp {

    public void run() {
        UserInterface ui = new UserInterface();
        int personCount = ui.inputPersonCount(), ladderHeight = ui.inputLadderCount();

        GameDisplay.showLadderInfo(getLadderInfo(personCount, ladderHeight));
    }

    public String[][] getLadderInfo(int personCount, int ladderHeight) {
        String[][] ladderInfo = new String[ladderHeight][personCount * 2 - 1];
        Random rd = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ladderHeight; i++) {
            IntStream.range(0, personCount * 2 - 1).forEach(j -> sb.append(j % 2 == 0 ? "|" : (rd.nextInt(2) == 0 ? " " : "-")));
            ladderInfo[i] = sb.toString().split("");
            sb.setLength(0);
        }

        return ladderInfo;
    }

}
