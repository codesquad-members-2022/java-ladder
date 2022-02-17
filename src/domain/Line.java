package domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        // 라인 좌표 값에 선이 있는지 유무 판단하는 로직 추가
        for (int i = 0; i < countOfPerson - 1; i++) {
            this.points.add(setRandomValue(i));
        }
    }

    public Boolean get(int index) {
        if (index < 0 || index >= points.size()) {
            throw new IndexOutOfBoundsException();
        }
        return points.get(index);
    }

    private boolean setRandomValue(int index) {
        Random rand = new Random();
        int temp = rand.nextInt(2); // 0, 1 중 하나의 값
        if (temp == 1 && !checkLineOverlap(index)) {
            return true;
        }

        return false;
    }

    private boolean checkLineOverlap(int index) {
        if (index != 0) {
            return this.points.get(index - 1);
        }
        return false;
    }
}
