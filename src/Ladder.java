import java.util.Random;
import java.util.Scanner;

public class Ladder {

    Scanner sc = new Scanner(System.in);
    Random ran = new Random();

    public int inputInfo(String Questions){
        System.out.println(Questions);
        return sc.nextInt();
    }

    public String[][] ladderInfo(int Player, int LadderHeight){

        String[][] ladder = new String[LadderHeight][Player*2-1];
        makeLadder(ladder);

        return ladder;
    }

    private void makeLadder(String[][] ladder){
        String[] RandomLine = {" ", "-"};
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (j % 2 == 0){
                    ladder[i][j] = "|";
                } else {
                    ladder[i][j] = RandomLine[ran.nextInt(2)];
                }
            }
        }
    }

    public void printLadder(String[][] ladder){
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }

}
