package domain;

import java.util.ArrayList;
import java.util.List;

public class UserDefineLadder {
    Line line;

    public UserDefineLadder(int numOfPerson) {
        line = new Line(numOfPerson);
    }

    public int run(int startLine) {
        if(!line.isMarkedPosition(startLine)){ // 그대로 이동
            return startLine;
        }

        if(startLine-1 >= 0) { // 좌측 처리하기
            if (line.isMarkedPosition(startLine - 1)) {
                return startLine - 1;
            }
        }
        // 우측 처리하기
        return startLine + 1;
    }

    public boolean makeLadderAt(int startPosition) {
        line.makeLadderAt(startPosition);
        return true;
    }
}
