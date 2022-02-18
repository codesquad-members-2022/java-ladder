package domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactoryImpl implements LadderFactory {

    private static final float ATTACH_HORIZONTAL_LINE_PROBABILITY = 0.5f;

    public static LadderFactoryImpl instance = new LadderFactoryImpl();

    private LadderFactoryImpl() {}

    public static LadderFactoryImpl getInstance() {
        return instance;
    }

    @Override
    public Ladder create(int numberOfUsers, int height) {
        Ladder ladder = new Ladder(makeLadderFrame(numberOfUsers, height));
        drawAllVerticalLine(ladder);
        drawAllHorizontalLine(ladder);
        return ladder;
    }

    private List<LadderRow> makeLadderFrame(int numberOfUsers, int height) {
        int width = 2*numberOfUsers - 1;

        return IntStream.range(0, height)
                .mapToObj(row -> makeLadderRow(width))
                .collect(Collectors.toList());
    }

    private void drawAllVerticalLine(Ladder ladder) {
        IntStream.range(0, ladder.height())
                .forEach(row -> setRowVerticalLine(ladder, row));
    }

    private void drawAllHorizontalLine(Ladder ladder) {
        IntStream.range(0, ladder.height())
                .forEach(row -> setRowHorizontalLine(ladder, row));
    }

    private LadderRow makeLadderRow(int width) {
        List<LadderElement> ladderRowFrame = makeLadderRowFrame(width);
        return new LadderRow(ladderRowFrame);
    }

    private List<LadderElement> makeLadderRowFrame(int width) {
        return IntStream.range(0, width)
                        .mapToObj(column -> LadderElement.EMPTY_LINE)
                        .collect(Collectors.toList());
    }

    private void setRowVerticalLine(Ladder ladder, int row) {
        IntStream.range(0, ladder.width())
                .filter(this::isUserColumn)
                .forEach(column -> setVerticalLine(ladder, row, column));
    }

    private void setRowHorizontalLine(Ladder ladder, int row) {
        IntStream.range(0, ladder.width())
                .filter(this::isHorizontalLineColumn)
                .forEach(column -> setHorizontalLine(ladder, row, column));
    }

    private void setVerticalLine(Ladder ladder, int row, int column) {
        ladder.drawLadderElement(column, row, LadderElement.VERTICAL_LINE);
    }

    private void setHorizontalLine(Ladder ladder, int row, int column) {
        if (canDrawHorizontalLine(ladder, row, column)) {
            ladder.drawLadderElement(column, row, randomLadderElement());
            return;
        }
        ladder.drawLadderElement(column, row, LadderElement.EMPTY_LINE);
    }

    private boolean canDrawHorizontalLine(Ladder ladder, int row, int column) {
        if (isUserColumn(column)) {
            return false;
        }
        if (column == 1) {
            return true;
        }
        return ladder.getLadderElement(column - 2, row) == LadderElement.EMPTY_LINE;
    }

    private LadderElement randomLadderElement() {
        boolean attachHorizontalLine = generateRandomBool(ATTACH_HORIZONTAL_LINE_PROBABILITY);
        return (attachHorizontalLine) ? LadderElement.HORIZONTAL_LINE : LadderElement.EMPTY_LINE;
    }

    private boolean generateRandomBool(float probabilityOfTrue) {
        double randomFloat = Math.random();
        boolean randomBool = (0<= randomFloat) && (randomFloat < probabilityOfTrue);
        return randomBool;
    }

    private boolean isUserColumn(int column) {
        return (column%2 == 0);
    }

    private boolean isHorizontalLineColumn(int column) {
        return !isUserColumn(column);
    }
}
