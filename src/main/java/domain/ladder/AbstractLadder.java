package domain.ladder;

import domain.LadderSize;
import domain.Line;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLadder implements Ladder{
    public static final String INVALID_HEIGHT_INPUT_MESSAGE = "사다리의 높이는 1이상 이여야 합니다.";
    public static final String INVALID_PERSON_NUM_INPUT_MESSAGE = "가능한 사람의 수는 1명 이상입니다.";

    protected final int height;
    protected final List<Line> lines;
    protected final LadderSize ladderSize;

    public AbstractLadder(int height, int numOfPerson) {
        isValidInput(height, numOfPerson);
        this.height = height;
        this.lines = new ArrayList<>();
        this.ladderSize = LadderSize.create(height, numOfPerson);
        makeLines(numOfPerson);
    }

    protected abstract void makeLines(int numOfPerson); // 추상 팩토리 패턴

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

    @Override
    public int run(int startLine) {
        for(int i = 0; i < lines.size(); i++){
            startLine = lines.get(i).switchLadderLine(startLine);
            continue;
        }
        return startLine;
    }

    @Override
    public List<Line> getLines() {
        return lines;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
