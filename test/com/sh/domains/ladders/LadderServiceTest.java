package com.sh.domains.ladders;

import static com.sh.domains.players.PlayersTest.*;
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

class LadderServiceTest {
	public static final String TEST_SYMBOL_LADDER = "-----";
	public static final int VERTICAL_LENGTH_OF_LADDER = 5;
	private Ladder ladder;
	private LadderService ladderService;

	static Predicate<String> isNotNull = isStringBlank.negate();

	@BeforeEach
	void beforeEach() {
		List<String> names = getNames();
		ladder = new Ladder(names.size(), VERTICAL_LENGTH_OF_LADDER);
		ladderService = new LadderService();
	}

	@DisplayName("사다리 길이 확인")
	@Test
	void acceptable_the_result_of_ladder_length_for_print_out() {
		String regex = "[\\s\\|]";
		String ladderText = ladderService.resultOfLadder(ladder);

		String actual = pickLineAndMaxText(1, regex, ladderText);

		assertEquals(TEST_SYMBOL_LADDER, actual);
	}

	/**
	 * 	출력문이 세로순으로는(y축) 플레이어들 이름, 사다리, 사디리 결과 순입니다.
	 * 	- 첫째줄 이용한 이름 테스트
	 * 	- 둘째줄 이후 이용한 사다리 라인 확인 테스트
	 * 	- 마지막줄 이용한 사다리 결과 테스트
	 * @param idx
	 * @param regex
	 * @param ladderText
	 * @return
	 */
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
