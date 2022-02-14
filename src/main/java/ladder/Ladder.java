package ladder;

import java.util.Random;
import java.util.Scanner;

public class Ladder {
    public void makeLadder(int n, int m) {
        int line = (2 * n) - 1;
        String[][] ladder = new String[line][m];

        for (int i = 0; i < m; i++) { //세로
            for (int j = 0; j < line; j++) {//가로
                if (j % 2 == 0){
                    ladder[i][j] = "|";
                    continue;
                }
                Random random = new Random();
                int randomNum = random.nextInt(2);
                if (randomNum == 0) {
                    ladder[i][j] = "--";
                }else {
                    ladder[i][j] = "  ";
                }
            }
        }
        for (String[] strings : ladder) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여 인원수?");
        int people = sc.nextInt();
        System.out.println("최대 사다리 높이?");
        int ladderHeight = sc.nextInt();

        Ladder ladder = new Ladder();
        ladder.makeLadder(people, ladderHeight);
    }
}
