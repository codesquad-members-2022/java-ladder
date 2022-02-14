package ladder;

import java.util.Random;
import java.util.Scanner;

public class Ladder {
    public String[][] makeLadder(int n, int m) {
        return getDrawingLadder(getLadderArr(getLine(n), m));
    }

    private int getLine(int n) {
        return (2 * n) - 1;
    }

    private String[][] getLadderArr(int line, int m) {
        String[][] ladder = new String[line][m];
        return ladder;
    }

    private String[][] getDrawingLadder(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) { //세로
            for (int j = 0; j < ladder[i].length; j++) {//가로
                ladder = drawingStick(ladder, i, j);
                ladder = drawingLine(ladder, i, j);
            }
        }
        return ladder;
    }

    private String[][] drawingLine(String[][] ladder, int i, int j) {
        if (getRandomNum() == 0) {
            ladder[i][j] = "--";
            return ladder;
        }
        ladder[i][j] = "  ";
        return ladder;
    }

    private String[][] drawingStick(String[][] ladder, int i, int j) {
        if (j % 2 == 0){
            ladder[i][j] = "|";
        }
        return ladder;
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(2);
    }

    private void printLadder(String[][] ladder) {
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
        String[][] StringLadder = ladder.makeLadder(people, ladderHeight);

        ladder.printLadder(StringLadder);
    }
}
