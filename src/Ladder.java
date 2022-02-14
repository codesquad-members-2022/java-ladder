import java.util.Random;

public class Ladder {
    public void Player(int player, int height) {
        String[][] ladder = new String[height][player * 2 - 1];
        String[] RandomLine = {" ", "-"};

        Random ran = new Random();

        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {

                if (j % 2 == 0) {
                    ladder[i][j] = "|";
                } else {
                    ladder[i][j] = RandomLine[ran.nextInt(2)];
                }
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }
}