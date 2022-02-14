public class LadderGame {

    String[][] arr;
    int user;
    int height;

    LadderGame() {

    }

    public void init(int user, int height) {
        // TODO: 2022/02/14
        //  user 3, height 5 가 들어와있다
        this.user = user;
        this.height = height;

    }

    void makeLadder() {

        arr = new String[height][user];
    }

    void randomSetLine() {

    }

    void game() {
        makeLadder();
        randomSetLine();
    }
}
