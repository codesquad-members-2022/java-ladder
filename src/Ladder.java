import java.util.Random;

public class Ladder {

    Random ran = new Random();


    private void MakeLadder(String[][] ladder){
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

    public void PrintLadder(String[][] ladder){
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }

}