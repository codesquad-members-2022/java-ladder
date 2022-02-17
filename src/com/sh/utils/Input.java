package com.sh.utils;

import java.util.Scanner;

public class Input {
	private static final Scanner scanner = new Scanner(System.in);

	public Input() {
	}

	public String nextLine() {
		return scanner.nextLine();
	}

	public int nextInt() {
		return scanner.nextInt();
	}

	public static void scanClose() {
		scanner.close();
	}
}
