package com.sh.utils;

import static com.sh.utils.GameMessage.*;

import java.util.function.Predicate;

public class InputVerification {
	private static Predicate<Integer> isNumberOfPeople = (count) -> (count < MIN_NUMBER_OF_PEOPLE || count > MAX_NUMBER_OF_PEOPLE);

	public static void isValidNumberOfPeople(Integer numberOfPeople) {
		if (isNumberOfPeople.test(numberOfPeople)) {
			throw new RuntimeException(ERROR_NUMBER_OF_PEOPLE);
		}
	}

	public static void isValidHeightOfLadder(Integer height, int minHeight) {
		if (height < minHeight || height > MAX_HEIGHT_OF_LADDER) {
			throw new RuntimeException(errorHeightRangeOfLadder(minHeight));
		}
	}
}
