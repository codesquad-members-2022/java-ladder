package com.sh.utils;

import java.util.Random;

public class RandomNumber {
	private static final RandomNumber RANDOM_NUMBER = new RandomNumber();

	public static RandomNumber getInstance() {
		return RANDOM_NUMBER;
	}

	public int getInt(int limit) {
		Random random = new Random();
		int number = random.nextInt(limit);
		return number;
	}
}
