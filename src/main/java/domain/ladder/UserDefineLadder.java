package domain.ladder;

import domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserDefineLadder extends AbstractLadder{
    public UserDefineLadder(int height, int numOfPerson) {
        super(height, numOfPerson);
    }

    public void makeLines(int numOfPerson) {
        IntStream.range(0, height).forEach(i -> lines.add(new Line(numOfPerson)));
    }

    public boolean makeLadderAt(int height, int startPosition) {
        lines.get(height).makeLadderAt(startPosition); // 인접한 이웃에게만 연락했으니, 디미터원칙 위배 X??
        return true;
    }
}
