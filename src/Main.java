import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder();

        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇명인가요?");
        int Player = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int LadderHeight = sc.nextInt();

        ladder.Player(Player,LadderHeight);
    }
}