package sadari;

import java.util.Random;

public class Ladder {
    private String[][] ladder;
    private String step;

    public void makeLadder(int people, int height) {
        people = people * 2 - 1;
        this.ladder = new String[height][people];
        for (int row = 0; row < ladder.length; row++) {
            checkLadderParts(row);
        }
        print(ladder);
    }

    public void checkLadderParts (int row) {
        for (int column = 0; column < ladder[row].length; column++) {
            ladder[row][column] = drawLines(column);
        }
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

    public void print(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }
}

