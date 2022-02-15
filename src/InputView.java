import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public int getInt(String message) {
        System.out.println(message);
        return Integer.parseInt(sc.nextLine());
    }

    public void close() {
        sc.close();
    }
}
