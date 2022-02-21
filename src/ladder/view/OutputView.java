package ladder.view;

import ladder.domain.Group;
import ladder.domain.Ladder;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public static final char END_POINT_SYMBOL = '*';
    private static final String OUTPUT_SINGLE_REWARD = "실행 결과";
    private static final String NAME_FORMAT = String.format("%%-%1$d.%1$ds", Group.NAME_LENGTH_LIMIT);
    private static final String OUTRO = "굶주린 야생의 %s(이)가 사다리를 먹어치웠다. 다음은 내 차례다. 나를 기억해ㅈ -END-";

    private static final String RAIL = "|";
    private static final String STEP = "-";
    private static final String EMPTY = " ";
    private static final int STEP_WIDTH = Group.NAME_LENGTH_LIMIT + 1;
    private static final String SECTION_WITH_STEP = RAIL + STEP.repeat(STEP_WIDTH);
    private static final String SECTION_WITHOUT_STEP = RAIL + EMPTY.repeat(STEP_WIDTH);

    public void printLayout(Ladder ladder, Group playerGroup, Group rewardGroup) {
        System.out.println();
        printGroup(playerGroup);
        printLadder(ladder);
        printGroup(rewardGroup);
        System.out.println();
    }

    public void printResult(String reward) {
        System.out.println(OUTPUT_SINGLE_REWARD);
        System.out.println(reward);
        System.out.println();
    }

    public void printAllResult(String allResult) {
        System.out.println("실행 결과");
        System.out.println(allResult);
    }

    public void printOutro(String endOfProgramSignal) {
        System.out.printf(OUTRO, endOfProgramSignal);
    }

    private void printGroup(Group group) {
        System.out.println(IntStream.range(0, group.count())
                .mapToObj(group::getName)
                .map(this::formatNameToFixedLength)
                .map(s -> END_POINT_SYMBOL + s + ' ')
                .collect(Collectors.joining()));
    }

    private void printLadder(Ladder ladder) {
        System.out.print(renderLadder(ladder));
    }

    private String renderLadder(Ladder ladder) {
        return IntStream.range(0, ladder.getHeight())
                .mapToObj(i -> renderLadderRow(ladder, i))
                .collect(Collectors.joining());
    }

    private StringBuilder renderLadderRow(Ladder ladder, int yPosition) {
        return IntStream.range(0, ladder.getWidth())
                .mapToObj(i -> ladder.hasStepAt(i, yPosition) ? SECTION_WITH_STEP : SECTION_WITHOUT_STEP)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .append(RAIL)
                .append(System.lineSeparator());
    }

    private String formatNameToFixedLength(String name) {
        return String.format(NAME_FORMAT, name);
    }
}
