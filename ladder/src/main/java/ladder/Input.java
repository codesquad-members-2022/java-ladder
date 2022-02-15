package ladder;

import java.util.Scanner;

public class Input {
    Scanner scan = new Scanner(System.in);
    public int inputString() {
        return Integer.parseInt(scan.nextLine());
    }

    public void close() {
        scan.close();
    }
}
