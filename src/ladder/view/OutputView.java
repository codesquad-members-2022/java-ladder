package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Group;

public class OutputView {
    public void printLayout(Group group, Ladder ladder) {
        System.out.println();
        printPlayers(group);
        printLadder(ladder);
    }

    private void printPlayers(Group group) {
        System.out.println(group);
    }

    private void printLadder(Ladder ladder) {
        System.out.println(ladder.render());
    }
}
