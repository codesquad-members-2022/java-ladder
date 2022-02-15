import java.util.Scanner;

public class Data {

    private int userCount;
    private int ladderLength;

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요 ?");
        userCount = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요 ?");
        ladderLength = sc.nextInt();
    }

    public int getUserCount() {
        return userCount;
    }

    public int getLadderLength() {
        return ladderLength;
    }
}
