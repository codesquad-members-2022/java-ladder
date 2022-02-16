package io;

import java.util.Scanner;

public class Input {
    Scanner scan = new Scanner(System.in);

    public int inputString() {
        return scan.nextInt();
    }

    public void close() {
        scan.close();
    }
}
