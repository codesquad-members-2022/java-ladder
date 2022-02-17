package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.view.View;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Ladder ladder = View.createLadder();
        List<Line> map = ladder.getMap();
        View.printMap(map);
    }
}
