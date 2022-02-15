import java.util.Scanner;

public class Prompt {

    public static int inputPlayer() {
        Scanner sc = new Scanner(System.in);
        Printer.outputPlayerPrompt();

        return sc.nextInt();
    }

    public static int inputHeight() {
        Scanner sc = new Scanner(System.in);
        Printer.outputHeightPrompt();

        int height = sc.nextInt();
        sc.close();

        return height;
    }

}
