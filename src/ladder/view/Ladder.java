package ladder.view;

import ladder.domain.Line;
import ladder.domain.UserManager;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final int HORIZON_LENGTH = 10;
    private UserManager userManager;
    private List<Line> lineList;
    private int userSize;
    private int stepSize;

    public Ladder(UserManager userManager, int ladderNum) {
        this.userManager = userManager;
        userSize = this.userManager.allUserNumber;
        stepSize = ladderNum;
        lineList = new ArrayList<>();
        for (int i = 0; i < stepSize; i++) {
            lineList.add(new Line(userSize));
        }
    }

    public void print() {
        String allUserName = userManager.allUserRegister;
        System.out.println(allUserName);
        for (int i = 0; i < stepSize; i++) {
            assembleLadder(i);
        }
    }

    private void assembleLadder(int stepCount) {
        Line line = lineList.get(stepCount);
        for (int i = 0; i < userSize; i++) {
            boolean pointLimitCheck = lineList.get(stepCount).getPoints().size() > i;
            boolean isPoint = pointLimitCheck ? line.getPoints().get(i) : false;
            String horizon = initHorizon(isPoint, HORIZON_LENGTH);
            System.out.print('|' + horizon);
        }
        System.out.println();
    }

    private String initHorizon(boolean isPoint, int horizonLength) {
        StringBuilder sb = new StringBuilder();
        char temp = isPoint ? '-' : ' ';
        for (int i = 0; i < horizonLength; i++) {
            sb.append(temp);
        }
        return sb.toString();
    }
}
