package com.sh.domains;

import static com.sh.views.InputVerification.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sh.domains.ladders.Ladder;
import com.sh.domains.ladders.LadderService;
import com.sh.domains.players.Players;

class LadderServiceTest {
	public static final String TEST_SYMBOL_LADDER = "-----";
	private Ladder ladder;
	private LadderService ladderService;

	static Predicate<String> isNotNull = isStringBlank.negate();

/*	@BeforeEach
	void beforeEach() {
		List<String> names = getNames();
		ladder = new Ladder(names.size(), 5);
		ladderService = new LadderService();
	}

	@DisplayName("사다리 길이 확인")
	@Test
	void acceptable_the_result_of_ladder_length_for_print_out() {
		String regex = "[\\s\\|]";
		String ladderText = ladderService.resultOfPlay();

		String actual = pickLineAndMaxText(1, regex, ladderText);

		assertEquals(TEST_SYMBOL_LADDER, actual);
	}*/

	public static String pickLineAndMaxText(int idx, String regex, String ladderText) {
		String line = ladderText.split(System.lineSeparator())[idx];
		String separated = line.replaceAll(regex, ",");
		String[] datas = separated.split(",");
		String maxLength = maxLengthText(datas);
		return maxLength;
	}

	private static String maxLengthText(String[] names) {
		return Arrays.stream(names)
			.filter(isNotNull::test)
			.max((a, b) -> (a.length() - b.length()))
			.get();
	}

}
