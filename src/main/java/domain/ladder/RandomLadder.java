package domain.ladder;

import domain.LadderSize;
import domain.Line;
import domain.Position;

import java.util.*;
import java.util.stream.IntStream;

public class RandomLadder extends AbstractLadder {
    public static final double DEFAULT_PERCENT = 0.3;

    public RandomLadder(int height, int numOfPerson) {
        super(height, numOfPerson);
    }

    protected void makeLines(int numOfPerson) {
        IntStream.range(0, height).forEach(i -> lines.add(new Line(numOfPerson)));

        List<Position> positionList = toPositions(makeStartPositions());
        for (Position position : positionList) {
            lines.get(position.getX()).makeLadderAt(position.getY()-1);
        }
    }

    public List<Integer> makeStartPositions() {
        int totalPositions = ladderSize.getTotalPositions();
        int countOfLine = ladderSize.getCountOfLine(DEFAULT_PERCENT);
        return makeUniquePositions(totalPositions, countOfLine);
    }

    private List<Integer> makeUniquePositions(int totalPositions, int count) {
        List<Integer> list = new LinkedList<>();
        while (list.size() < count) {
            addRandomNumToList(list, randomRangeInt(1, totalPositions));
        }
        return list;
    }

    private void addRandomNumToList(List<Integer> list, int randomPosition) {
        if(!ladderSize.isMultipleOfPersonNum(randomPosition) && !isExisted(list, randomPosition)){
            list.add(randomPosition);
        }
    }

    List<Position> toPositions(List<Integer> positions) {
        List<Position> list = new ArrayList<>();
        for (int position : positions) {
            int[] ints = ladderSize.convertPositionToXY(position);
            list.add(new Position(ints[0], ints[1]));
        }
        return list;
    }

    public static boolean isExisted(List<Integer> startPositions, int randomPosition) {
        return startPositions.stream()
                .anyMatch(p -> p == randomPosition || p == randomPosition-1 || p == randomPosition+1);
    }

    private static int randomRangeInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max-min) + 1) + min;
    }
}
