import java.util.Random;

public class LadderGame {

    private String[][] arr;
    private int user;
    private int height;
    private static final String LADDERUNIT = "|";
    private static final String LINEUNIT = "-";
    private static final String BLANK = " ";

    LadderGame() {

    }

    public void init(int user, int height) {
        this.user = user;
        this.height = height;
        build();
    }

    public void build() {
        int width = user * 2 - 1;
        arr = new String[height][width];
      
        for (int i = 0; i < arr.length; i++) {
            addLadderUnit(i);
        }
        Output.printLadderGame(arr);
    }

    private void addLadderUnit(int col) {
        for (int row = 0; row < arr[col].length; row++) {
            createUnit(col, row);
        }
    }

    private String createUnit(int col, int row) {
        if (row % 2 == 1) {
            return createRandomLine(col, row);
        }
        return arr[col][row] = LADDERUNIT;
    }

    private String createRandomLine(int col, int row) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return arr[col][row] = LINEUNIT;
        }
        return arr[col][row] = BLANK;
    }
}
