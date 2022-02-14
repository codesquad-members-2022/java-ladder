public class Launcher {
    private int player;
    private int height;
    private String[][] result;

    public void run() {
        player = Print.inputPlayer();
        height = Print.inputHeight();
        result = makeLadder(player,height);

        Print.result(result);
    }

    private String[][] makeLadder(int player, int height) {
        int row = height;
        int column = 2 * player - 1;

        String[][] ladder = new String[row][column];
        ladder = makeLegBridge(ladder);

        return ladder;
    }

    private String[][] makeLegBridge(String[][] ladder) {
        Launcher launcher = new Launcher();

        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                insertLegAndBridge(ladder, launcher, i, j);
            }
        }

        return ladder;
    }

    private void insertLegAndBridge(String[][] ladder, Launcher launcher, int i, int j) {
        if (j % 2 == 0) {
            ladder[i][j] = "|";
        } else {
            launcher.randomMakeBridge();
            ladder[i][j] = randomMakeBridge();
        }
    }
}
