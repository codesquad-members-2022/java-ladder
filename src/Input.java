import java.util.Scanner;

public class Input {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputRules(String message) {
        System.out.println(message);

        return sc.nextInt();
    }

    public static void close() {
        sc.close();
    }

}
