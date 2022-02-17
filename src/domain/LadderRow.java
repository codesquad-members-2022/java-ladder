package domain;

import java.util.Random;
import java.util.stream.IntStream;

public class LadderRow extends ShapeInitializer{
    public static final Random RANDOM = new Random();

    private int section;
    private String row;
    private boolean previousSectionIsBridge;

    public LadderRow(int numberOfLine) {
        this.section = numberOfLine * 2 - 1;
        this.row = init();
        this.previousSectionIsBridge = false;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private String init() {
        StringBuilder sb = new StringBuilder();

        sb.append(builder());
        IntStream.range(0, section).forEach(sectionIndex -> sb.append(determineSectionShape(sectionIndex)));
        return sb.toString();
    }

    private String builder() {
        // 초기 공백 설정
        if (isEven(NameTag.NAME_TAG_SIZE)) {
            return initEmpty(NameTag.NAME_TAG_SIZE / 2 - 1);
        }
        return initEmpty(NameTag.NAME_TAG_SIZE / 2);
    }

    private String determineSectionShape(int sectionIndex) {
        if (isEven(sectionIndex)) {
            return "|";
        }
        return initRandomShape();
    }

    private String initRandomShape() {
        if (previousSectionIsBridge) {
            switchpreviousSectionIsBridge();
            return initEmpty(NameTag.NAME_TAG_SIZE - 1);
        }

        // 랜덤 모양(empty or bridge) 생성 로직
        if (RANDOM.nextBoolean()) {
            switchpreviousSectionIsBridge();
            return initBridge(NameTag.NAME_TAG_SIZE - 1);
        }
        return initEmpty(NameTag.NAME_TAG_SIZE - 1);
    }

    private void switchpreviousSectionIsBridge() {
        this.previousSectionIsBridge = !previousSectionIsBridge;
    }

    public String getRow() {
        return row;
    }
}
