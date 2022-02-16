import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("Utility class");
    }

    public static int getInputNumer(String message) {
        OutputView.printMessage(message);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void close() {
        scanner.close();
    }
}
