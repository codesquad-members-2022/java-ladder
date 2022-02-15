import java.util.Random;

public class LadderGame {

    String[][] arr;
    int user;
    int height;
    String ladderUnit = "|";
    String lineUnit = "-";
    String blank = " ";

    LadderGame() {

    }

    public void init(int user, int height) {
        this.user = user;
        this.height = height;
        userToBlink();
        makeLadder();
    }

    public void makeLadder() {
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
                arr[i][j] = ladderUnit;
            }
        }
    }

    private void lineOrBlank(int i, int j) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            arr[i][j] = lineUnit;
        } else {
            arr[i][j] = blank;
        }
    }

    private void userToBlink() {
        user = user * 2 - 1;
    }
}
