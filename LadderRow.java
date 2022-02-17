import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderRow extends ShapeInitializer{
    public static final Random RANDOM = new Random();

    private int numberOfLine;
    private String row;
    private boolean lastRandomShapeIsBridge;

    public LadderRow(int numberOfLine) {
        this.numberOfLine = numberOfLine;
        this.row = init();
        this.lastRandomShapeIsBridge = false;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private String init() {
        StringBuilder sb = new StringBuilder();

        sb.append(builder());
        IntStream.range(0, numberOfLine).forEach(lineIndex -> sb.append(determineLineShape(lineIndex)));
        return sb.toString();
    }

    private String builder() {
        // 초기 공백 설정
        if (isEven(NameTag.NAME_TAG_SIZE)) {
            return initEmpty(NameTag.NAME_TAG_SIZE / 2 - 1);
        }
        return initEmpty(NameTag.NAME_TAG_SIZE / 2);
    }

    private String determineLineShape(int line) {
        if (isEven(line)) {
            return "|";
        }
        return initRandomShape();
    }

    private String initRandomShape() {
        if (lastRandomShapeIsBridge) {
            switchLastRandomShapeIsBridge();
            return initEmpty(NameTag.NAME_TAG_SIZE - 1);
        }

        // 랜덤 모양(line or padding) 생성 로직
        if (RANDOM.nextBoolean()) {
            switchLastRandomShapeIsBridge();
            return initBridge(NameTag.NAME_TAG_SIZE - 1);
        }
        return initEmpty(NameTag.NAME_TAG_SIZE - 1);
    }

    public void switchLastRandomShapeIsBridge() {
        this.lastRandomShapeIsBridge = !lastRandomShapeIsBridge;
    }

    public String getRow() {
        return row;
    }
}
