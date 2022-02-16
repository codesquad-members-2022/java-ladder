import java.util.Random;

public class Ladder {
    private int numberOfPeople;
    private int heightOfLadder;
    private char[][] charLadder;

    Ladder(int n, int m) {
        this.numberOfPeople = n;
        this.heightOfLadder = m;
        this.init();
    }

    private void init() {
        this.charLadder = make();
    }

    private char[][] make() {
        char[][] ladder = new char[heightOfLadder][numberOfPeople-1];
        for (int i = 0; i < heightOfLadder; i++) {
            ladder[i] = makeRow();
        }
        return ladder;
    }

    private char[] makeRow() {
        char[] rowOfLadder = new char[numberOfPeople-1];
        for (int i = 0; i < rowOfLadder.length; i++) {
            rowOfLadder[i] = setRandomValue();
        }
        return rowOfLadder;
    }

    private char setRandomValue() {
        Random rand = new Random();
        int temp = rand.nextInt(2); // 0, 1 중 하나의 값
        if (temp==0){
            return ' ';
        }
        return '-';
    }

    public String Info() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < heightOfLadder; i++) {
            sb.append(rowOfLadderInfo(i));
        }

        return sb.toString();
    }

    private String rowOfLadderInfo(int index) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for(int i=0; i<numberOfPeople-1; i++){
            sb.append(charLadder[index][i]);
            sb.append("|");
        }
        sb.append("\n");
        return sb.toString();
    }



}

