package ladder.domain;

import java.util.ArrayList;

public class LadderProcessor {

    Line line;

    public LadderProcessor() {

        line = new Line();
    }

    public ArrayList<ArrayList<String>> getLadderInfo(int playerCount, int ladderHeight) {
        ArrayList<ArrayList<String>> arrayDoubleList = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            arrayDoubleList.add(getLadderRowData(playerCount));
        }

        return arrayDoubleList;
    }

    private ArrayList<String> getLadderRowData(int playerCount) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < playerCount * 2 - 1; i++) {
            arrayList.add(i % 2 == 0 ? "|" : line.getLadderLine());
        }
        line.flag = false;

        return arrayList;
    }

}
