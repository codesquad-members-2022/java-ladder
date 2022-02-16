package step3;

import java.util.ArrayList;
import java.util.Random;

public class GameApp {

    boolean flag = false; // 사다리 Line 겹치지 않도록 flag 설정
    Random rd = new Random();

    public void run() {
        UserInterface ui = new UserInterface();
        ArrayList<String> players = ui.inputPlayerList();
        if (players == null) return;

        GameDisplay.showLadderInfo(players, getLadderInfo(players.size(), ui.inputLadderHeight()));
    }

    private ArrayList<ArrayList<String>> getLadderInfo(int playerCount, int ladderHeight) {
        ArrayList<ArrayList<String>> arrayDoubleList = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            arrayDoubleList.add(getLadderRowData(playerCount));
        }

        return arrayDoubleList;
    }

    private ArrayList<String> getLadderRowData(int playerCount) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < playerCount * 2 - 1; i++) {
            arrayList.add(i % 2 == 0 ? "|" : getLadderLine());
        }
        flag = false;

        return arrayList;
    }

    private String getLadderLine() {
        int randomValue = rd.nextInt(2);
        String line = randomValue == 1 && !flag ? "-----" : "     ";
        flag = randomValue == 1 ? true : false;

        return line;
    }
}
