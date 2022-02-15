import java.util.Random;

public class Ladder {
    private String[][] ladder;
    private String step;

    public void makeLadder(int people, int height) {
        this.ladder = new String[height][people];
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (j%2 == 0){
                    ladder[i][j] ="|";
                }  else {
                    ladder[i][j] = makeRandomSteps();
                }
            }
        }
        print(ladder);
    }

    public String makeRandomSteps(){
        Random rd = new Random();
        int random = rd.nextInt(100) % 2;
        if (random == 0) {
            step = " ";
        }
        if (random == 1) {
            step = "-";
        }
        return step;
    }

    public void print(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }
}
