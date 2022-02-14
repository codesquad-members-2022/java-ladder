import java.util.Random;
import java.util.Scanner;

public class App {

    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {

        int playerCount = inputRules("참여할 사람은 몇 명인가요?");
        int ladderHeight = inputRules("최대 사다리 높이는 몇 개인가요?");

        String[][] ladder = createLadder(playerCount, ladderHeight);

        printLadder(ladder);
    }

    private static String[][] createLadder(int playerCount, int ladderHeight) {
        String[][] ladder = new String[ladderHeight][(playerCount * 2) - 1];

        addLadeerData(ladder);

        return ladder;
    }

    private static void addLadeerData(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (j == 0 || j % 2 == 0) {
                    ladder[i][j] = "|";
                } else if (random.nextBoolean()) {
                    ladder[i][j] = "-";
                } else {
                    ladder[i][j] = " ";
                }
            }
        }
    }

    private static int inputRules(String x) {
        System.out.println(x);
        return sc.nextInt();
    }

    private static void printLadder(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[0].length; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }

}
