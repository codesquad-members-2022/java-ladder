package com.sh.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVerification {
	public static final String SYMBOL_NAME_SEPARATOR = ",";
	private static final Integer MIN_NUMBER_OF_PEOPLE = 2;
	private static final Integer MAX_NUMBER_OF_PEOPLE = 15;
	private static final Integer MIN_HEIGHT_OF_LADDER = MIN_NUMBER_OF_PEOPLE-1;
	private static final Integer MAX_HEIGHT_OF_LADDER = 20;
	public static final Integer MAX_LENGTH_OF_NAME = 5;
	public static final String OUTPUT_NAME_LIST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	public static final String OUTPUT_MAX_HEIGHT_OF_LADDER = "최대 사다리 높이는 몇 개인가요?";
	private static final String ERROR_NUMBER_OF_PEOPLE = String.format("%d명 이상 %d명 범위내로 입력하세요.", MIN_NUMBER_OF_PEOPLE, MAX_NUMBER_OF_PEOPLE);
	private static final String ERROR_NOT_INCLUDE_COMMA = String.format("이름은 쉼표(,)로 구분지어 입력하세요. %s", ERROR_NUMBER_OF_PEOPLE);
	public static final String ERROR_WHITE_SPACE = "이름을 입력하세요(공백은 안 됩니다.)";
	public static final String ERROR_DUPLICATED_NAME = "이름을 중복해서 입력하지 마세요";
	public static final String ERROR_LENGTH_OF_NAME = "이름은 5글자 이내여야 합니다.";

	private static final String SEPARATOR_REGEX = "[\\,]+";

	private static Predicate<Integer> isMinPeoples = (count) -> (count < MIN_NUMBER_OF_PEOPLE);
	private static Predicate<Integer> isMaxPeoples = (count) -> (count > MAX_NUMBER_OF_PEOPLE);
	public static Predicate<String> isStringBlank = (word) -> (word.isBlank());
	public static Predicate<String> isValidName = (name) -> (name.length() > MAX_LENGTH_OF_NAME);

	public static void isValidNames(String inputValues) {
		String[] names = getSplit(inputValues);
		isWhiteSpace(inputValues);
		isRulesOfInput(inputValues);
		isDuplicated(names);
		isValidNumberOfPeoples(names);
		isValidLengthOfEachNames(names);
	}

	private static String[] getSplit(String inputValues) {
		return inputValues.split(SYMBOL_NAME_SEPARATOR);
	}

	private static void isWhiteSpace(String inputValues) {
		if (isStringBlank.test(inputValues)) {
			throw new IllegalArgumentException(ERROR_WHITE_SPACE);
		}
		checkEachName(inputValues);
	}

	private static void checkEachName(String inputValues) {
		String[] names = getSplit(inputValues);
		Arrays.stream(names)
			.filter(String::isBlank)
			.findAny()
			.ifPresent(s -> {
				throw new IllegalArgumentException(ERROR_WHITE_SPACE);
			});
	}

	private static void isRulesOfInput(String inputValues) {
		if (!isIncludedSeparator(inputValues)) {
			throw new IllegalArgumentException(ERROR_NOT_INCLUDE_COMMA);
		}
	}

	private static void isValidNumberOfPeoples(String[] names) {
		if (isMaxPeoples.or(isMinPeoples).test(names.length)) {
			throw new IllegalArgumentException(ERROR_NUMBER_OF_PEOPLE);
		}
	}

	private static void isDuplicated(String[] names) {
		boolean isUnique = checkUnique(names);
		if (!isUnique) {
			throw new IllegalArgumentException(ERROR_DUPLICATED_NAME);
		}
	}

	private static boolean checkUnique(String[] names) {
		return Arrays.stream(names)
			.map(String::trim)
			.allMatch(new HashSet<>()::add);
	}

	private static void isValidLengthOfEachNames(String[] names) {
		Arrays.stream(names)
			.map(String::trim)
			.filter(name -> isValidName.or(isStringBlank).test(name))
			.findAny()
			.ifPresent(invalid -> {throw new IllegalArgumentException(ERROR_LENGTH_OF_NAME);});
	}

	private static boolean isIncludedSeparator(String inputValues) {
		Pattern compile = Pattern.compile(SEPARATOR_REGEX);
		Matcher matcher = compile.matcher(inputValues);
		return matcher.find();
	}

	public static void isValidHeightOfLadder(int height, int minHeight) {
		if (height < minHeight || height < MIN_HEIGHT_OF_LADDER || height > MAX_HEIGHT_OF_LADDER
			|| minHeight < MIN_HEIGHT_OF_LADDER) {
			throw new IllegalArgumentException(errorHeightRangeOfLadder(minHeight));
		}
	}

	private static String errorHeightRangeOfLadder(int minHeight) {
		return String.format("높이 %d 이상 %d 이하로 입력하세요.", minHeight, MAX_HEIGHT_OF_LADDER);
	}
}
