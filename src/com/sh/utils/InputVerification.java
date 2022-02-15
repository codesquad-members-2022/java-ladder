package com.sh.utils;

import static com.sh.utils.GameMessage.*;

import java.util.function.Predicate;

public class InputVerification {
	private static Predicate<Integer> isNumberOfPeople = (count) -> (count < MIN_NUMBER_OF_PEOPLE || count > MAX_NUMBER_OF_PEOPLE);

	public static void isValidNumberOfPeople(Integer numberOfPeople) {
		if (isNumberOfPeople.test(numberOfPeople)) {
			throw new IllegalArgumentException(ERROR_NUMBER_OF_PEOPLE);
		}
	}

	public static void isValidHeightOfLadder(Integer height, int minHeight) {
		if (height < minHeight || height < MIN_HEIGHT_OF_LADDER || height > MAX_HEIGHT_OF_LADDER || minHeight < MIN_HEIGHT_OF_LADDER) {
			throw new IllegalArgumentException(errorHeightRangeOfLadder(minHeight));
		}
	}
}
