package app.jinan159.ladder.stretegy;

import app.jinan159.ladder.meta.Elements;

public class DefaultGameMapStretegy implements LadderGameMapStretegy {
    @Override
    public Elements getLadderElementsOnPotision(int x, int y) {
        // 홀수 번째 column은 세로줄을 입력함
        if (x % 2 == 0) {
            return Elements.V_LINE;
        }

        if (isEmptyPosition(x, y)) {
            return Elements.EMPTY;
        }

        return Elements.H_LINE;
    }

    // 빈 공간이 들어올 자리인지, 아닌지를 반환하는 가상의 알고리즘
    private boolean isEmptyPosition(int x, int y) {
        return ((x * y) + (x + y)) % 3 == 0;
    }
}
