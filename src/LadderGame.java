import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 인원 수를 입력하십시오.");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("사다리의 높이를 입력하십시오.");
        int m = Integer.parseInt(sc.nextLine());
        System.out.println();

        Ladder ladder = new Ladder(m, n);
        System.out.println(ladder.render());

        sc.close();
    }
}