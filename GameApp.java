import java.util.Random;

public class GameApp {

    public void run() {
        UserInterface ui = new UserInterface();
        int personCount = ui.inputPersonCount(), ladderHeight = ui.inputLadderCount();

        GameDisplay.showLadderInfo(getLadderInfo(personCount, ladderHeight));
    }

    public String[][] getLadderInfo(int personCount, int ladderHeight) {
        String[][] ladderInfo = new String[ladderHeight][personCount * 2 - 1];

        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < personCount * 2 - 1; j++) {
                ladderInfo[i][j] = j % 2 == 0 ? "|" : (new Random().nextInt(2) == 0 ? " " : "-");
            }
        }

        return ladderInfo;
    }

}
