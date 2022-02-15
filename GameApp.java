package step2;

import java.util.Random;

public class GameApp {

    public void run() {
        UserInterface ui = new UserInterface();
        int playerCnt = ui.inputPlayerCnt(), ladderHeight = ui.inputLadderCount();

        GameDisplay.showLadderInfo(getLadderInfo(playerCnt, ladderHeight));
    }

    public String[][] getLadderInfo(int playerCnt, int ladderHeight) {
        String[][] ladderInfo = new String[ladderHeight][playerCnt * 2 - 1];

        for (int i = 0; i < ladderHeight; i++) {
            ladderInfo[i] = getLadderRowData(playerCnt);
        }

        return ladderInfo;
    }

    public String[] getLadderRowData(int playerCnt) {
        Random rd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playerCnt * 2 - 1; i++) {
            sb.append(i % 2 == 0 ? "|" : (rd.nextInt(2) == 0 ? " " : "-"));
        }

        return sb.toString().split("");
    }

}
