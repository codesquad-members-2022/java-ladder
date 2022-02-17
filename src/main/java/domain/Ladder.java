package domain;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String USER_LINE = "|";
    private static final String CONNECTION_LINE = "-----";
    private static final String EMPTY_SPACE = "     ";
    private final int ladderWidth;
    private final int ladderHeight;
    private List<List<String>> ladders;


    public Ladder(int ladderHeight, int ladderWidth) {
        if (!validateLadderHeight(ladderHeight)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        this.ladderHeight = ladderHeight;
        this.ladderWidth = ladderWidth;
        initLadder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ladders.forEach(ladder->{
            StringBuilder row = new StringBuilder();
            ladder.forEach(s->row.append(s));
            sb.append(row + "\n");
        });
        return sb.toString();
    }

    private void initLadder() {
        ladders = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladders.add(createLadderRow());
        }
    }

    private List<String> createLadderRow() {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < ladderWidth; i++) {
            row.add(createRowElement(i, row));
        }
        return row;
    }

    private String createRowElement(int n, List<String> row) {
        if (n % 2 == 0) {
            return USER_LINE;
        }
        return createLine(n,row);
    }

    private String createLine(int n, List<String> row) {
        if(n == 1) return createLineByRandom();
        return row.get(n - 2).equals(CONNECTION_LINE) ? EMPTY_SPACE : createLineByRandom();
    }

    private String createLineByRandom() {
        return RandomUtil.getRandomNum(10) >= 4 ? CONNECTION_LINE : EMPTY_SPACE;
    }

    private boolean validateLadderHeight(int lineCount) {
        return lineCount >= 1;
    }
}
