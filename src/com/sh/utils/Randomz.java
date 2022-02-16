package com.sh.utils;

import java.util.Random;

public class Randomz {
	private static final Randomz RANDOM_NUMBER = new Randomz();

	public static Randomz getInstance() {
		return RANDOM_NUMBER;
	}

	public int getInt(int limit) {
		Random random = new Random();
		int number = random.nextInt(limit);
		return number;
	}

	public boolean getBoolean() {
		Random random = new Random();
		boolean isBool = random.nextBoolean();
		return isBool;
	}
}
