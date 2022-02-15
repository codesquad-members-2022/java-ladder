package domain.ladder;

public class LadderFactoryImpl implements LadderFactory{

    public static LadderFactoryImpl instance = new LadderFactoryImpl();

    private LadderFactoryImpl() {}

    public static LadderFactoryImpl getInstance() {
        return instance;
    }

    @Override
    public Ladder create(int entry, int height) {
        LadderElement[][] ladderElements = new LadderElement[height][ladderWidth(entry)];
        for (int y=0; y<ladderHeight(ladderElements); y++) {
            setVerticalLine(ladderElements, y);
            setHorizontalLine(ladderElements, y);
        }
        return new Ladder(ladderElements);
    }

    @Override
    public Ladder copy(Ladder original) {
        LadderElement[][] originalElements = original.getLadderElements();
        LadderElement[][] copyElements = new LadderElement[ladderHeight(originalElements)][ladderWidth(originalElements)];

        for (int y=0; y<ladderHeight(copyElements); y++) {
            copyRow(originalElements, copyElements, y);
        }

        return new Ladder(copyElements);
    }

    private void copyRow(LadderElement[][] originalElements, LadderElement[][] copyElements, int y) {
        for (int x = 0; x < ladderWidth(copyElements); x++) {
            copyElements[y][x] = originalElements[y][x];
        }
    }

    private void setVerticalLine(LadderElement[][] ladderElements, int row) {
        for (int x=0; x<ladderWidth(ladderElements); x += 2) {
            ladderElements[row][x] = LadderElement.VERTICAL_LINE;
        }
    }

    private void setHorizontalLine(LadderElement[][] ladderElements, int row) {
        for (int x=1; x< ladderWidth(ladderElements); x += 2) {
            ladderElements[row][x] = randomLadderElement();
        }
    }


    private LadderElement randomLadderElement() {
        double randomFloat = Math.random();
        boolean randomBool = (0<= randomFloat) && (randomFloat < 0.5);
        return (randomBool) ? LadderElement.HORIZONTAL_LINE : LadderElement.EMPTY_LINE;
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
