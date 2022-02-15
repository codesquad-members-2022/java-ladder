import java.util.Random;

public class LadderGame {

    String[][] arr;
    int user;
    int height;
    private static final String LADDERUNIT = "|";
    private static final String LINEUNIT = "-";
    private static final String BLANK = " ";

    LadderGame() {

    }

    public void init(int user, int height) {
        this.user = user;
        this.height = height;
        userToBlank();
        build();
    }

    public void build() {
        arr = new String[height][user];

        for (int i = 0; i < arr.length; i++) {
            addLadderUnit(i);
        }
        Output.printLadderGame(arr);
    }

    private void addLadderUnit(int i) {
        for (int j = 0; j < arr[i].length; j++) {
            if (j % 2 == 1) {
                lineOrBlank(i, j);
            } else {
                arr[i][j] = LADDERUNIT;
            }
        }
    }

    private String lineOrBlank(int i, int j) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return arr[i][j] = LINEUNIT;
        }
        return arr[i][j] = BLANK;
    }

    private void userToBlank() {
        user = user * 2 - 1;
    }
}
