import java.util.Scanner;

public class LadderGame {
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println(SystemMessage.UI_INPUT_PLAYER_COUNT.getMessage());
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(SystemMessage.UI_INPUT_LADDER_HEIGHT.getMessage());
        int m = Integer.parseInt(sc.nextLine());
        System.out.println();

        Ladder ladder = new Ladder(m, n);
        System.out.println(ladder.render());

        sc.close();
    }
}
