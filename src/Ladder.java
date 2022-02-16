import java.util.Random;

public class Ladder {

    Random ran = new Random();
    char[][] ladder;
    int playerCount;
    int heightLadder;

    public Ladder(int playerCount, int heightLadder) {
        this.playerCount = playerCount;
        this.heightLadder = heightLadder;
        this.ladder = new char[heightLadder][playerCount*2-1];
    }

    public char[][] makeLadder(){
        for (int row = 0; row < ladder.length; row++) {
            ladder = makeLadderColumn(ladder, row);
        }
        return ladder;
    }

    private char[][] makeLadderColumn(char[][] ladder, int row){
        for (int column = 0; column < ladder[row].length; column++) {
            ladder = makeLine(ladder, row, column);
            ladder = makeStick(ladder, row, column);
        }
        return ladder;
    }

    private char[][] makeLine(char[][] ladder, int row, int column){
        if (ran.nextBoolean()){
            ladder[row][column] = ' ';
            return ladder;
        }
        ladder[row][column] = '-';
        return ladder;
    }

    private char[][] makeStick(char[][] ladder, int row, int column){
        if (column % 2 == 0) {
            ladder[row][column] = '|';
        }
        return ladder;
    }
}
