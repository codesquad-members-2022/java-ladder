package sadari;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private List<List<String>> ladderList = new ArrayList<>();
    private String step;
    private final int width;
    private final int height;

    public Ladder(int width, int height) {
        this.width = width * 2 - 1;
        this.height = height;
        makeLadder(height);
    }

    public void makeLadder(int height) {
        for (int row = 0; row < height; row++){
            ladderList.add(checkLadderParts());
        }
        print(ladderList);
    }

    public ArrayList<String> checkLadderParts() {
        ArrayList<String> innerList = new ArrayList<>();
        for (int column = 0; column < width; column++){
            innerList.add(drawLines(column));
        }
        return innerList;
    }

    public String drawLines(int column){
        Random rd = new Random();
        int random = rd.nextInt(100) % 2;
        if (column % 2 == 0) {
            return step ="|";
        }
        if (random == 0) {
            return step = " ";
        }

        return step = "-";
    }

    public void print(List<List<String>> ladderList) {
        for (List<String> strings : ladderList){
            strings.stream().forEach(System.out::print);
            System.out.println();
        }
    }
}


