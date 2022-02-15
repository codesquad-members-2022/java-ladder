import java.util.Scanner;

public class Input {
    private Scanner sc = new Scanner(System.in);
    public int getNumber() {
         return sc.nextInt();
    }

    public void scannerClose() {
        sc.close();
    }
}