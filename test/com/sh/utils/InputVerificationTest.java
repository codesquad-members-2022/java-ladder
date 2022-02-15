package com.sh.utils;

import static com.sh.utils.GameMessage.*;
import static com.sh.utils.InputVerification.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputVerificationTest {

	/*
		입력 가능한 인원수는 GameMessage 를 따른다.
	 */
/*	private static final int invalidRangeOfMin = MIN_NUMBER_OF_PEOPLE - 1;
	private static final int invalidRangeOfMax = MAX_NUMBER_OF_PEOPLE + 1;

	@ParameterizedTest
	@ValueSource(ints = {Integer.MAX_VALUE, invalidRangeOfMin, invalidRangeOfMax, Integer.MAX_VALUE})
	void invalid_number_of_people_input_value_test(int numberOfPeople) {
		System.out.println(numberOfPeople);
	}*/

	private static final int rangeOfMin = 2;
	private static final int rangeOfMax = 15;
	private static final int invalidRangeOfMin = 1;
	private static final int invalidRangeOfMax = 16;

	/*
		입력된 사람 최소수 2명이라면, 사라리 최소 높이 1
	 */
	private static final int heightOfMin = invalidRangeOfMin-1;
	private static final int heightOfMax = 20;
	private static final int invalidHeightOfMin = 0;
	private static final int invalidHeightOfMax = 21;

	@ParameterizedTest
	@ValueSource(ints = {Integer.MAX_VALUE, invalidRangeOfMin, invalidRangeOfMax, Integer.MAX_VALUE})
	void invalid_number_of_people_input_value_test(int numberOfPeople) {
		assertThrows(IllegalArgumentException.class, () -> {
			isValidNumberOfPeople(numberOfPeople);
		});
	}

	@ParameterizedTest
	@ValueSource(ints = {rangeOfMin, rangeOfMax})
	void number_of_people_input_value_test(int numberOfPeople) {
		isValidNumberOfPeople(numberOfPeople);
	}

	@ParameterizedTest
	@MethodSource("provideHeights")
	void invalid_height_of_ladder_input_value_test(int maxHeight, int minHeight) {
		assertThrows(IllegalArgumentException.class, () -> {
			isValidHeightOfLadder(maxHeight, minHeight);
		});
	}

	private static Stream<Arguments> provideHeights() {
		return Stream.of(
			Arguments.of(invalidHeightOfMax, heightOfMin),
			Arguments.of(heightOfMax, invalidHeightOfMin),
			Arguments.of(heightOfMin, heightOfMin)
		);
	}
}
