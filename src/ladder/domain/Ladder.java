package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final String RAIL = "|";
    private static final String STEP = "-";
    private static final String EMPTY = " ";
    private static final int STEP_WIDTH = Group.NAME_LENGTH_LIMIT + 1;
    private static final String SECTION_WITH_STEP = RAIL + STEP.repeat(STEP_WIDTH);
    private static final String SECTION_WITHOUT_STEP = RAIL + EMPTY.repeat(STEP_WIDTH);

    private final int height;
    private final int width;
    private final List<LadderRow> ladderRowList;

    protected Ladder(int height, int playerCount) {
        this.height = height;
        this.width = playerCount - 1;
        this.ladderRowList = new ArrayList<>(width);
        build();
    }

    public String render() {
        return ladderRowList.stream()
                .map(this::renderRow)
                .collect(Collectors.joining());
    }

    private StringBuilder renderRow(LadderRow ladderRow) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < width; i++) {
            sb.append(ladderRow.hasStepAt(i) ? SECTION_WITH_STEP : SECTION_WITHOUT_STEP);
        }

        return sb.append(RAIL).append(System.lineSeparator());
    }

    private void build() {
        for (int i = 0; i < height; i++) {
            ladderRowList.add(new LadderRow(width));
        }
    }
}
