import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {
    public static final int LEFT_PADDING_SIZE = 1;
    public static final int RIGHT_PADDING_SIZE = 1;
    public static final int NAME_TAG_SIZE = InputManager.LIMIT_NAME_LENGTH + LEFT_PADDING_SIZE + RIGHT_PADDING_SIZE;

    private ArrayList<String> ladder;
    private Random random;
    private int numberOfPlayer;
    private String[] nameTags;
    private boolean lastRandomShapeIsLine;

    public Ladder(String[] names, int ladderDepth) {
        this.ladder = new ArrayList<>();
        this.random = new Random();
        this.numberOfPlayer = names.length;
        this.nameTags = wrapPlayerName(names);
        this.lastRandomShapeIsLine = false;

        IntStream.range(0, ladderDepth)
                .forEach(row -> ladder.add(initLadderRow(numberOfPlayer * 2 - 1)));
    }

    private String[] wrapPlayerName(String[] names) {
        return Arrays.stream(names)
                .map(name -> {
                    // 지정 된 NAME_TAG_SIZE에서 입력받은 name의 길이만큼 빼서 추가해야 할 padding의 갯수를 구한다.
                    int numberOfPadding = NAME_TAG_SIZE - name.length();
                    return initNameTag(name, numberOfPadding);
                }).toArray(String[]::new);
    }

    private String initNameTag(String name, int numberOfPadding) {
        StringBuilder sb = new StringBuilder();
        if (isEven(numberOfPadding)) {
            sb.append(initPadding(numberOfPadding / 2));
            sb.append(name);
            sb.append(initPadding(numberOfPadding / 2));
            return sb.toString();
        }
        sb.append(initPadding(numberOfPadding / 2));
        sb.append(name);
        sb.append(initPadding(numberOfPadding / 2 + 1));
        return sb.toString();
    }

    private String initLadderRow(int ladderLine) {
        StringBuilder sb = new StringBuilder();

        // 초기 띄어쓰기 설정
        sb.append(setDefaultPaddingLadderModel());
        // 열이 짝수라면 "|", 홀수라면 " " or "-" 입력
        IntStream.range(0, ladderLine).forEach(line -> sb.append(determineLineShape(line)));
        return sb.toString();
    }

    private String setDefaultPaddingLadderModel() {
        if (isEven(NAME_TAG_SIZE)) {
            return initPadding(NAME_TAG_SIZE / 2 - 1);
        }
        return initPadding(NAME_TAG_SIZE / 2);
    }

    private String determineLineShape(int line) {
        if (isEven(line)) {
            return "|";
        }
        return initRandomShape();
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private String initRandomShape() {
        if (lastRandomShapeIsLine) {
            setLastRandomShapeIsLine(false);
            return initPadding(NAME_TAG_SIZE - 1);
        }

        // 랜덤 모양(line or padding) 생성 로직
        if (random.nextBoolean()) {
            setLastRandomShapeIsLine(true);
            return initLine(NAME_TAG_SIZE - 1);
        }
        return initPadding(NAME_TAG_SIZE - 1);
    }

    private String initPadding(int numberOfPadding) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, numberOfPadding).forEach(i -> sb.append(" "));
        return sb.toString();
    }

    private String initLine(int numberOfPadding) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, numberOfPadding).forEach(i -> sb.append("-"));
        return sb.toString();
    }

    public ArrayList<String> getLadder() {
        return ladder;
    }

    public String[] getNameTags() {
        return nameTags;
    }

    public void setLastRandomShapeIsLine(boolean lastRandomShapeIsLine) {
        this.lastRandomShapeIsLine = lastRandomShapeIsLine;
    }
}
