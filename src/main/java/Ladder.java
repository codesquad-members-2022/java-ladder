import java.util.Random;

public class Ladder {
    public String[][] makeLadder(int n, int m) {
        return getDrawingLadder(getLadderArr(getLine(n), m));
    }

    private int getLine(int n) {
        return (2 * n) - 1;
    }

    private String[][] getLadderArr(int line, int m) {
        String[][] ladder = new String[line][m];
        return ladder;
    }

    private String[][] getDrawingLadder(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) { //세로
            for (int j = 0; j < ladder[i].length; j++) {//가로
                ladder = drawingLine(ladder, i, j);
                ladder = drawingStick(ladder, i, j);
            }
        }
        return ladder;
    }

    private String[][] drawingLine(String[][] ladder, int i, int j) {
        if (getRandomNum() == 0) {
            ladder[i][j] = "--";
            return ladder;
        }
        ladder[i][j] = "  ";
        return ladder;
    }

    private String[][] drawingStick(String[][] ladder, int i, int j) {
        if (j % 2 == 0){
            ladder[i][j] = "|";
        }
        return ladder;
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(2);
    }
}
