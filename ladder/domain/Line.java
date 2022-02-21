package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private boolean flag; // 사다리 Line 겹치지 않도록 flag 설정
    private Random rd;
    private List<Boolean> points;

    public Line(int playerCount) {
        rd = new Random();
        points = new ArrayList<>();

        for (int i = 0; i < playerCount - 1; i++) {
            points.add(getLadderLine());
        }
        flag = false;
    }

    // 라인의 이전 좌표 값에 선이 있는지 유무를 판단하여 선 추가 유무 결정
    private boolean getLadderLine() {
        if (flag == true) {
            flag = false;
            return false;
        }
        int randomValue = rd.nextInt(2);
        if (randomValue == 1) {
            flag = true;
        }

        return randomValue == 1 ? true : false;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
