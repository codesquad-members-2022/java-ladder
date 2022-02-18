package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserDefineLadder {
    private final List<Line> lines;
    private final int height;

    public UserDefineLadder(int height, int numOfPerson) {
        this.height = height;
        this.lines = new ArrayList<>();
        makeLines(numOfPerson);
    }

    private void makeLines(int numOfPerson) {
        IntStream.range(0, height).forEach(i -> lines.add(new Line(numOfPerson)));
    }

    public int run(int startLine) {
        for(int i = 0; i < lines.size(); i++){
            startLine = switchLadderLine(startLine, i);
            continue;
        }
        return startLine;
    }

    private int switchLadderLine(int startLine, int i) {
        if(!lines.get(i).isMarkedPosition(startLine)){ // 그대로 이동
            return startLine;
        }

        if(startLine -1 >= 0) { // 좌측 처리하기
            if (lines.get(i).isMarkedPosition(startLine - 1)) {
                return startLine - 1;
            }
        }
        // 우측 처리하기
        return startLine + 1;
    }

    public boolean makeLadderAt(int height, int startPosition) {
        lines.get(height).makeLadderAt(startPosition); // 인접한 이웃에게만 연락했으니, 디미터원칙 위배 X??
        return true;
    }
}
