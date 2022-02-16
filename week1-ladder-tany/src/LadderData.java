import java.util.Scanner;

public class LadderData {

    private int ladderLength;

    public void inputLadderData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("최대 사다리 높이는 몇 개인가요 ?");
        ladderLength = sc.nextInt();
    }

    public int getLadderLength() {
        return ladderLength;
    }
}
