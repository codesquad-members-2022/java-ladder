package step2.service;

import java.util.Random;

public class GameService {
    public static final char LADDER = '-';
    public static final char HEIGHT = '|';
    public static final char SPACE = ' ';

    public char[][] makeLadder(int personNumber, int height) {
        int ladderWidth = 1 + (personNumber-1)*2;
        char[][] ladder = new char[height][ladderWidth];
        fillHeightLine(ladder);
        fillLadder(ladder);
        return ladder;
    }

    private void fillLadder(char[][] ladder) {
        for(int i = 0; i < ladder.length; i++){
            for(int j = 1; j < ladder[1].length; j += 2){
                fillRandomLadder(ladder, i, j);
            }
        }
    }

    private void fillRandomLadder(char[][] ladder, int i, int j) {
        Random random = new Random();
        if(random.nextInt(10) < 4){
            ladder[i][j] = LADDER;
            return;
        }

        ladder[i][j] = SPACE;
    }

    private void fillHeightLine(char[][] ladder) {
        for(int i = 0; i < ladder.length; i++){
            for(int j = 0; j < ladder[0].length; j += 2){
                ladder[i][j] = HEIGHT;
            }
        }
    }
}
