package io;

import java.util.Scanner;

public class Input {
    Scanner scan = new Scanner(System.in);

    public int inputInteger() {
        return scan.nextInt();
    }

    public String inputString() {
        return scan.nextLine();
    }

    public void close() {
        scan.close();
    }
}
