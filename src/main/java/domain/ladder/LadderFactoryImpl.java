package domain.ladder;

import java.util.stream.IntStream;

public class LadderFactoryImpl implements LadderFactory{

    private static final float HORIZONTAL_LINE_PROBABILITY = 0.5f;

    public static LadderFactoryImpl instance = new LadderFactoryImpl();

    private LadderFactoryImpl() {}

    public static LadderFactoryImpl getInstance() {
        return instance;
    }

    @Override
    public Ladder create(int entry, int height) {
        LadderElement[][] ladderElements = new LadderElement[height][ladderWidth(entry)];

        setAllVerticalLine(ladderElements);
        setAllHorizontalLine(ladderElements);

        return new Ladder(ladderElements);
    }

    @Override
    public Ladder copy(Ladder original) {
        LadderElement[][] originalElements = original.getLadderElements();
        LadderElement[][] copyElements = new LadderElement[ladderHeight(originalElements)][ladderWidth(originalElements)];

        copyAllRow(originalElements, copyElements);
        return new Ladder(copyElements);
    }

    private void setAllVerticalLine(LadderElement[][] ladderElements) {
        IntStream.range(0, ladderHeight(ladderElements))
                .forEach(row -> setVerticalLine(ladderElements, row));
    }

    private void setAllHorizontalLine(LadderElement[][] ladderElements) {
        IntStream.range(0, ladderHeight(ladderElements))
                .forEach(row -> setHorizontalLine(ladderElements, row));
    }

    private void setVerticalLine(LadderElement[][] ladderElements, int row) {
        IntStream.range(0, ladderWidth(ladderElements))
                .filter(column -> column%2 == 0)
                .forEach(column -> ladderElements[row][column] = LadderElement.VERTICAL_LINE);
    }

    private void setHorizontalLine(LadderElement[][] ladderElements, int row) {
        IntStream.range(0, ladderWidth(ladderElements))
                .filter(column -> column%2 != 0)
                .forEach(column -> ladderElements[row][column] = randomLadderElement());
    }

    private void copyAllRow(LadderElement[][] originalElements, LadderElement[][] copyElements) {
        IntStream.range(0, ladderHeight(copyElements))
                .forEach(row -> copyRow(originalElements, copyElements, row));
    }

    private void copyRow(LadderElement[][] originalElements, LadderElement[][] copyElements, int row) {
        IntStream.range(0, ladderWidth(copyElements))
                .forEach(column -> copyElements[row][column] = originalElements[row][column]);
    }

    private LadderElement randomLadderElement() {
        boolean randomBool = generateRandomBool(HORIZONTAL_LINE_PROBABILITY);
        return (randomBool) ? LadderElement.HORIZONTAL_LINE : LadderElement.EMPTY_LINE;
    }

    private boolean generateRandomBool(float probabilityOfTrue) {
        double randomFloat = Math.random();
        boolean randomBool = (0<= randomFloat) && (randomFloat < probabilityOfTrue);
        return randomBool;
    }

    private int ladderWidth(int entry) {
        return 2*entry - 1;
    }

    private int ladderWidth(LadderElement[][] ladder) {
        return ladder[0].length;
    }

    private int ladderHeight(LadderElement[][] ladder) {
        return ladder.length;
    }
}
