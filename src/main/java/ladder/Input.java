package ladder;

import java.util.Scanner;

public class Input {

    private static Scanner sc = new Scanner(System.in);
    public int getNumber(String message) {
        System.out.println(message);
        return sc.nextInt();
    }

    public void close() {
        sc.close();
    }
}
