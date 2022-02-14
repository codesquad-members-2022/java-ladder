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
}
