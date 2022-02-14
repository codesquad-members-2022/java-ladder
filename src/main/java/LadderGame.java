public class LadderGame {

    String[][] arr;
    int user;
    int height;
    String ladderUnit = "|";
    String lineUnit = "-";

    LadderGame() {

    }

    public void init(int user, int height) {
        this.user = user;
        this.height = height;
        makeLadder();
    }

    public void makeLadder() {
        arr = new String[height][user];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ladderUnit;
            }
        }
        Output.printLadderGame(arr);
    }

    void randomSetLine() {

    }

    void game() {
        makeLadder();
        randomSetLine();
    }
}
