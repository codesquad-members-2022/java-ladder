import java.util.Scanner;

public class App {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // n명의 사람의 수를 입력할 수 있어야 한다.
        int playerCount = inputRules("참여할 사람은 몇 명인가요?");

        // m개의 사다리 개수를 입력할 수 있어야 한다.
        int ladderHeight = inputRules("최대 사다리 높이는 몇 개인가요?");

        


    }

    private static int inputRules(String x) {
        System.out.println(x);
        return sc.nextInt();
    }



}
