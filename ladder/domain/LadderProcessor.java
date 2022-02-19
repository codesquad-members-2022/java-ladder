package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderProcessor {

    public List<Line> getLadderInfo(int playerCount, int ladderHeight) {
        List<Line> ladderInfo = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladderInfo.add(new Line(playerCount));
        }

        return ladderInfo;
    }
}
