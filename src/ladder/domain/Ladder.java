package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final int height;
    private final int playerCount;
    private final int width;
    private final List<LadderRow> ladderRowList;
    private final Map<Integer, Integer> resultTable = new HashMap<>();
    private final Climber climber = new Climber();

    public Ladder(int height, int playerCount) {
        this.height = height;
        this.playerCount = playerCount;
        this.width = playerCount - 1;
        this.ladderRowList = new ArrayList<>(width);
        build();
        buildResultTable();
    }

    public int getRewardIndex(int playerIndex) {
        return resultTable.get(playerIndex);
    }

    public boolean hasStepAt(int xPosition, int yPosition) {
        return ladderRowList.get(yPosition).hasStepAt(xPosition);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private void build() {
        for (int i = 0; i < height; i++) {
            ladderRowList.add(new LadderRow(width));
        }
    }

    private void buildResultTable() {
        for (int playerIndex = 0; playerIndex < playerCount; playerIndex++) {
            climber.initialize(playerIndex);
            climber.climbDown();
            resultTable.put(playerIndex, climber.endPosition);
        }
    }

    class Climber {
        int xPosition;
        int yPosition = 0;
        int endPosition = -1;

        void initialize(int xPosition) {
            this.xPosition = xPosition;
            yPosition = 0;
            endPosition = -1;
        }

        void climbDown() {
            while (yPosition < height) {
                moveLeftOrRightIfPossible();
                yPosition++;
            }

            endPosition = this.xPosition;
        }

        void moveLeftOrRightIfPossible() {
            if (canMoveLeft()) {
                xPosition--;
                return;
            }

            if (canMoveRight()) {
                xPosition++;
            }
        }

        boolean canMoveLeft() {
            if (xPosition == 0) {
                return false;
            }

            return ladderRowList.get(yPosition).hasStepAt(xPosition - 1);
        }

        boolean canMoveRight() {
            if (xPosition == width) {
                return false;
            }

            return ladderRowList.get(yPosition).hasStepAt(xPosition);
        }

    }
}
