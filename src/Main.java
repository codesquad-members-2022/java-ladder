import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int people = scn.nextInt() * 2 - 1;
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scn.nextInt();

        scn.close();
    }
}
