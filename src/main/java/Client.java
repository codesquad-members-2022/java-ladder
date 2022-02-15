import java.util.Scanner;

public class Client {

    public Client() {
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        Output.printUserCountNoti();
        int n = sc.nextInt();

        Output.printLadderCountNoti();
        int m = sc.nextInt();

        LadderGame ladderGame = new LadderGame();
        ladderGame.init(n, m);
    }
}
