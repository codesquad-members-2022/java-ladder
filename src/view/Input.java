package view;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);
    public static int getNumber() {
         return sc.nextInt();
    }

    public static void Close() {
        sc.close();
    }

    public static String getPlayer() {
        return sc.nextLine();
    }
}