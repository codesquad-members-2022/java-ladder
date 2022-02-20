package domain;

import java.rmi.dgc.Lease;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    public static final String INVALID_HEIGHT_INPUT_MESSAGE = "사다리의 높이는 1이상 이여야 합니다.";
    public static final String INVALID_PERSON_NUM_INPUT_MESSAGE = "가능한 사람의 수는 1명 이상입니다.";
    public static final double DEFAULT_PERCENT = 0.3;

    private final int height;
    private final List<Line> lines;
    private final LadderSize ladderSize;

    public Ladder(int height, int numOfPerson) {
        isValidInput(height, numOfPerson);
        this.ladderSize = LadderSize.create(height, numOfPerson);
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

        List<Position> positionList = toPositions(makeStartPositions());
        for (Position position : positionList) {
            lines.get(position.getX()).makeLadderAt(position.getY()-1);
        }
    }

    int[] makeStartPositions() {
        int totalPositions = ladderSize.getTotalPositions();
        int countOfLine = ladderSize.getCountOfLine(DEFAULT_PERCENT);
        int[] startPositions = new int[countOfLine];
        for (int i = 0; i < startPositions.length; i++) {
            int randomPosition = randomRangeInt(1, totalPositions);
            if(ladderSize.isMultipleOfPersonNum(randomPosition) || isExisted(startPositions, randomPosition)){
                i--;
                continue;
            }
            startPositions[i] = randomPosition;
        }
        return startPositions;
    }

    List<Position> toPositions(int[] positions){
        List<Position> list = new ArrayList<>();
        for (int position : positions) {
            int[] ints = ladderSize.convertPositionToXY(position);
            list.add(new Position(ints[0], ints[1]));
        }
        return list;
    }

    static boolean isExisted(int[] startPositions, int randomPosition) {
        return Arrays.stream(startPositions)
                .anyMatch(p -> p == randomPosition || p == randomPosition-1 || p == randomPosition+1);
    }

    public List<Line> getLines() {
        return lines;
    }
    public int getHeight() {
        return height;
    }

    private static int randomRangeInt(int min, int max){
        Random random = new Random();
        return random.nextInt((max-min) + 1) + min;
    }
}
