import java.util.Random;

public class Launcher {

    public void run() {
        int player = Prompt.inputPlayer();
        int height = Prompt.inputHeight();
        char[][] result = makeLadder(player, height);

        Printer.printResult(result);
    }

    private char[][] makeLadder(int player, int height) {
        int row = height;
        int column = 2 * player - 1;

        char[][] ladder = new char[row][column];
        ladder = makeLegBridge(ladder);

        return ladder;
    }

    private char[][] makeLegBridge(char[][] ladder) {
        Launcher launcher = new Launcher();

        for (int i = 0; i < ladder.length; i++) {
            makeColumnWise(ladder, launcher, i);
        }

        return ladder;
    }

    private void makeColumnWise(char[][] ladder, Launcher launcher, int i) {
        for (int j = 0; j < ladder[i].length; j++) {
            insertLegAndBridge(ladder, launcher, i, j);
        }
    }

    private void insertLegAndBridge(char[][] ladder, Launcher launcher, int i, int j) {
        launcher.randomMakeBridge();

        if (j % 2 == 0) {
            ladder[i][j] = '|';
            return;
        }
        ladder[i][j] = randomMakeBridge();
        return;
    }

    private char randomMakeBridge() {
        Random random = new Random();
        int a = random.nextInt(2);

        if (a == 0) {
            return '-';
        }
        return ' ';
    }
}
