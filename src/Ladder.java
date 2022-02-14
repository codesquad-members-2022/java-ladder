import java.util.Random;

public class Ladder {
    private String[][] ladder;
    private int random;

    public void makeLadder(int people, int height) {
        this.ladder = new String[height][people];
    }

    public void makeLadder2(String[][] ladder){
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (j%2 == 0){
                    ladder[i][j] ="|";
                }  else {
                    makeRandom();
                    if (random == 0) {
                        ladder[i][j] = " ";
                    } else {
                        ladder[i][j] = "-";
                    }
                }
            }
        }
        this.ladder = ladder;
    }

    public int makeRandom(){
        Random rd = new Random();
        int random = rd.nextInt(100) % 2;
        this.random = random;
        return random;
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
