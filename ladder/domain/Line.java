package ladder.domain;

import java.util.Random;

public class Line {

    boolean flag = false; // 사다리 Line 겹치지 않도록 flag 설정
    Random rd;

    Line() {
        rd = new Random();
    }

    public String getLadderLine() {
        int randomValue = rd.nextInt(2);
        String line = randomValue == 1 && !flag ? "-----" : "     ";
        flag = randomValue == 1 ? true : false;

        return line;
    }

}
