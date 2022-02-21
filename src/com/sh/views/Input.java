package com.sh.views;

import java.util.Scanner;

public class Input {
	private static final Scanner scanner = new Scanner(System.in);

	public Input() {
	}

	public static String nextLine() {
		return scanner.nextLine();
	}

	public static int nextInt() {
		return Integer.parseInt(nextLine());
	}

	public static void scanClose() {
		scanner.close();
	}
}
