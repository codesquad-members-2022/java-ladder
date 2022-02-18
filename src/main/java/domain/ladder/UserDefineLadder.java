package domain.ladder;

import domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserDefineLadder {
    public static final String INVALID_HEIGHT_INPUT_MESSAGE = "사다리의 높이는 1이상 이여야 합니다.";
    public static final String INVALID_PERSON_NUM_INPUT_MESSAGE = "가능한 사람의 수는 1명 이상입니다.";
    private final List<Line> lines;
    private final int height;

    public UserDefineLadder(int height, int numOfPerson) {
        isValidInput(height, numOfPerson);
        this.height = height;
        this.lines = new ArrayList<>();
        makeLines(numOfPerson);
    }

    private void isValidInput(int height, int numOfPerson) {
        if(!isValidHeight(height)){
            throw new IllegalArgumentException(INVALID_HEIGHT_INPUT_MESSAGE);
        }
        if(!isValidPersonNum(numOfPerson)){
            throw new IllegalArgumentException(INVALID_PERSON_NUM_INPUT_MESSAGE);
        }
    }

    private boolean isValidPersonNum(int numOfPerson) {return numOfPerson >= 1;}
    private boolean isValidHeight(int height) {return height > 0;}

    private void makeLines(int numOfPerson) {
        IntStream.range(0, height).forEach(i -> lines.add(new Line(numOfPerson)));
    }

    public int run(int startLine) {
        for(int i = 0; i < lines.size(); i++){
            startLine = lines.get(i).switchLadderLine(startLine);
            continue;
        }
        return startLine;
    }

    public boolean makeLadderAt(int height, int startPosition) {
        lines.get(height).makeLadderAt(startPosition); // 인접한 이웃에게만 연락했으니, 디미터원칙 위배 X??
        return true;
    }
}
