package com.sh.utils;

import java.util.Random;

public class RandomNo {
	private static final RandomNo randomNo = new RandomNo();

	public static RandomNo getInstance() {
		return randomNo;
	}

	public int getInt(int limit) {
		Random random = new Random();
		int number = random.nextInt(limit);
		return number;
	}
}
