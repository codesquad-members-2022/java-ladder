import java.util.Scanner;

public class Print {
    public static int inputPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");

        return sc.nextInt();
    }

    public static int inputHeight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return sc.nextInt();
    }
}
