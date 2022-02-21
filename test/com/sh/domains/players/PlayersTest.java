package com.sh.domains.players;

import static com.sh.views.InputVerification.*;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {
	public static final String TEST_MAX_LENGTH_NAME = "honux";
	private static final String TEST_MAX_LENGTH_RESULT = "로또1등!";
	private List<String> invalidShortNames = List.of("pobi", "  ");
	private List<String> invalidLongNames = getInvalidLongNames();
	private int invalidLength = MAX_NUMBER_OF_PEOPLE + 1;

	@DisplayName("적은 인원 - 예외")
	@Test
	void invalid_players_size_when_short() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Players(invalidShortNames, getResults());
		});
	}

	@DisplayName("한도 넘는 인원 - 예외")
	@Test
	void invalid_players_size_when_large() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Players(invalidLongNames, getResults());
		});
	}

	@DisplayName("플레이어스 생성")
	@Test
	void create_players() {
		List<String> names = getNames();
		List<Result> results = getResults();
		Players players = new Players(names, results);

		List<String> actual = players.getNames();

		assertTrue(actual.size() > MIN_NUMBER_OF_PEOPLE);
		assertTrue(actual.size() < invalidLength);
	}

	private List<String> getInvalidLongNames() {
		return IntStream.rangeClosed(0, invalidLength)
			.mapToObj(String::valueOf)
			.collect(toList());
	}

	public static List<String> getNames() {
		return List.of("pobi", TEST_MAX_LENGTH_NAME, "crong", "jk");
	}

	public static List<Result> getResults() {
		return List.of(new Result("꽝"), new Result(TEST_MAX_LENGTH_RESULT), new Result("3등"), new Result("2등"));
	}
}
