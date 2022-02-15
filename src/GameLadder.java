import java.util.Scanner;

public class GameLadder {
    public int[] gameInfo() {
        System.out.println("참여할 사람은 몇 명인가요?");
        int numOfPeople = inputNumber();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLadder = inputNumber();

        return new int[]{numOfPeople, heightOfLadder};
    }


    private int inputNumber() {
        return new Scanner(System.in).nextInt();
    }
}
