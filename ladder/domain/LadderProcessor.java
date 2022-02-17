package ladder.domain;

import java.util.ArrayList;

public class LadderProcessor {

    public ArrayList<Line> getLadderInfo(int playerCount, int ladderHeight) {
        ArrayList<Line> ladderInfo = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladderInfo.add(new Line(playerCount));
        }

        return ladderInfo;
    }
}
