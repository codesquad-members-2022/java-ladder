package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Group;

public class OutputView {
    public void printLayout(Ladder ladder, Group topGroup, Group bottomGroup) {
        System.out.println();
        printGroup(topGroup);
        printLadder(ladder);
        printGroup(bottomGroup);
    }

    private void printGroup(Group group) {
        System.out.println(group);
    }

    private void printLadder(Ladder ladder) {
        System.out.print(ladder.render());
    }
}
