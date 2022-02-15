package com.sh.utils;

public interface GameMessage {
	// game symbols to show
	String SYMBOL_IS_LADDER = "-";
	String SYMBOL_IS_NOT_LADDER = " ";
	String SYMBOL_LINE= "|";

	// scope
	Integer MIN_NUMBER_OF_PEOPLE = 2;
	Integer MAX_NUMBER_OF_PEOPLE = 15;
	Integer MIN_HEIGHT_OF_LADDER = MIN_NUMBER_OF_PEOPLE-1;
	Integer MAX_HEIGHT_OF_LADDER = 20;

	// game guide
	String OUTPUT_NUMBER_OF_PEOPLE = "참여할 사람은 몇 명인가요?";
	String OUTPUT_MAX_HEIGHT_OF_LADDER = "최대 사다리 높이는 몇 개인가요?";

	// error message
	String ERROR_NUMBER_OF_PEOPLE = String.format("%d명 이상 %d명 범위내로 입력하세요.", MIN_NUMBER_OF_PEOPLE, MAX_NUMBER_OF_PEOPLE);

	static String errorHeightRangeOfLadder(int minHeight) {
		return String.format("높이 %d 이상 %d 이하로 입력하세요.", minHeight, MAX_HEIGHT_OF_LADDER);
	}
}
