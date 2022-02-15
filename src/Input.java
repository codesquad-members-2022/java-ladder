import java.util.Scanner;

public class Input {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputRules(String x) {
        System.out.println(x);

        return sc.nextInt();
    }

}
