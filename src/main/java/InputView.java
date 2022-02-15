import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);
    public int getNumber(String message) {
        System.out.println(message);
        return sc.nextInt();
    }

    public void close() {
        sc.close();
    }
}
