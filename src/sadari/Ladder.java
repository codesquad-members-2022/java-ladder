package sadari;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private List<List<String>> ladderList = new ArrayList<>();
    private String step;
    private final int width;
    private final int height;
    private List<String> innerList;

    public Ladder(int width, int height) {
        this.width = width * 2 - 1;
        this.height = height;
        makeLadder(height);
    }

    public void makeLadder(int height) {
        for (int row = 0; row < height; row++) {
            ladderList.add(checkLadderParts());
        }
        print(ladderList);
    }

    public List<String> checkLadderParts() {
        innerList = new ArrayList<>();
        for (int column = 0; column < width; column++) {
            innerList.add(drawLines(column));
        }
        return innerList;
    }

    public String drawLines(int column) {
        Random rd = new Random();
        int random = rd.nextInt(100) % 2;
        if (column % 2 == 0) {
            return step = "|";
        }
        if (rd.nextBoolean() && checkBlank(column)) {
            return step = "-----";
        }

        return step = "     ";
    }

    public boolean checkBlank (int column) {
        if (column == 1) {
            return true;
        }
        if ("     ".equals(innerList.get(column - 2))){
            return true;
        }
        return false;
    }

    //TODO: 문자열 자체를 반환하게 해서.. or toString으로 출력할 문자열을 만들어서
    public void print(List<List<String>> ladderList) {
        StringBuilder sb = new StringBuilder();
        for (List<String> strings : ladderList) {
            sb.append("     ");
            strings.forEach(string -> sb.append(string));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}


