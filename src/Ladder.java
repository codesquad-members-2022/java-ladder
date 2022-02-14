public class Ladder {
    private String[][] ladder;

    public void makeLadder(int people, int height) {
        this.ladder = new String[height][people];
    }

    public void makeLadder2(String[][] ladder){
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (j%2 == 0){
                    ladder[i][j] ="|";
                }
            }
        }
        this.ladder = ladder;
    }
}
