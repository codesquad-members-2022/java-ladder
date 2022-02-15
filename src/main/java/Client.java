import java.util.Scanner;

public class Client {

    public Client() {
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        Output.userCountNoti();
        int n = sc.nextInt();

        Output.ladderCountNoti();
        int m = sc.nextInt();

        LadderGame ladderGame = new LadderGame();
        ladderGame.init(n, m);
    }
}