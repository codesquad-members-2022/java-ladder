import java.util.Random;

public class Launcher {
    private int player;
    private int height;
    private String[][] result;

    public void run() {
        player = Prompt.inputPlayer();
        height = Prompt.inputHeight();
        result = makeLadder(player,height);

        Printer.result(result);
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
            makeColumnWise(ladder, launcher, i);
        }

        return ladder;
    }

    private void makeColumnWise(String[][] ladder, Launcher launcher, int i) {
        for (int j = 0; j < ladder[i].length; j++) {
            insertLegAndBridge(ladder, launcher, i, j);
        }
    }

    private void insertLegAndBridge(String[][] ladder, Launcher launcher, int i, int j) {
        if (j % 2 == 0) {
            ladder[i][j] = "|";
        } else {
            launcher.randomMakeBridge();
            ladder[i][j] = randomMakeBridge();
        }
    }

    private String randomMakeBridge() {
        Random random = new Random();
        int a = random.nextInt(2);

        if(a == 0){
            return "-";
        }
        return " ";
    }
}
