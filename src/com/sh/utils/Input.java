package com.sh.utils;

import static com.sh.utils.GameMessage.*;
import static com.sh.utils.InputVerification.*;
import static com.sh.utils.Output.*;

import java.util.Scanner;

public class Input {
	private static final Scanner scanner = new Scanner(System.in);

	private Input() {
	}

	public static Integer getNumberOfPeople() {
		Input input = new Input();
		Integer numberOfPeople = input.nextInt();
		isValidNumberOfPeople(numberOfPeople);
		return numberOfPeople;
	}

	public static Integer getHeightOfLadder(int minHeight) {
		Input input = new Input();
		Integer maxHeightOfLadder = input.nextInt();
		isValidHeightOfLadder(maxHeightOfLadder, minHeight);
		return maxHeightOfLadder;
	}

	public static int getNumbers() {
		try {
			println.accept(OUTPUT_NUMBER_OF_PEOPLE);
			Integer numberOfPeople = getNumberOfPeople();
			return numberOfPeople;
		} catch (Exception e) {
			println.accept(e.getMessage());
			return getNumbers();
		}
	}

	public static int getHeight(int numberOfPeople) {
		try {
			int minHeight = numberOfPeople - 1;
			println.accept(OUTPUT_MAX_HEIGHT_OF_LADDER);
			Integer height = getHeightOfLadder(minHeight);
			return height;
		} catch (Exception e) {
			println.accept(e.getMessage());
			return getHeight(numberOfPeople);
		}
	}

	private Integer nextInt() {
		return scanner.nextInt();
	}

	public static void scanClose() {
		scanner.close();
	}
}
