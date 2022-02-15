import java.util.Scanner;

public class InputManager {
    Scanner sc;

    public InputManager() {
        this.sc = new Scanner(System.in);
    }

    public int inputNumber() {
        return sc.nextInt();
    }
}
