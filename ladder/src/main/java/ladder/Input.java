package ladder;

import java.util.Scanner;

public class Input {

    public int inputString() {
        Scanner scan = new Scanner(System.in);

        return Integer.parseInt(scan.nextLine());
    }
}