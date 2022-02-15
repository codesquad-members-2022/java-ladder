import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInputNumer(String message) {
        OutputView.printMessage(message);
        int result = Integer.parseInt(scanner.nextLine());
        return result;
    }


    public static void close() {
        scanner.close();
    }
}
